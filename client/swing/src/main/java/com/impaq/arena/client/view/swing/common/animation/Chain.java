package com.impaq.arena.client.view.swing.common.animation;

import com.google.common.base.Throwables;
import static com.google.common.collect.ImmutableList.copyOf;
import com.google.common.collect.Iterables;
import static com.google.common.collect.Iterables.size;
import com.google.common.eventbus.EventBus;
import com.impaq.arena.client.view.swing.common.AnimationFinish;
import com.impaq.arena.client.view.swing.common.AnimationListener;
import com.impaq.arena.client.view.swing.common.Animation;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class Chain implements Animation {
    
    public static Animation of(Animation animation) {
        return animation;
    }
    
    public static Animation of(Animation... animations) {
        return new Chain(animations);
    }
    
    private final Iterable<Animation> animations;
    private final EventBus bus = new EventBus();
    private State state = new Stopped();
    
    public Chain(Animation... animations) {
        this(copyOf(animations));
    }
    
    public Chain(Iterable<Animation> animations) {
        this.animations = animations;
    }
    
    @Override
    public void awaitFinish() {
        state.awaitFinish();
    }
    
    @Override
    public void play() {
        state.play();
    }
    
    @Override
    public void stop() {
        state.stop();
    }
    
    @Override
    public void registerListener(AnimationListener listener) {
        bus.register(listener);
    }
    
    @Override
    public void unregisterListener(AnimationListener listener) {
        bus.unregister(listener);
    }
    
    private abstract class State implements Animation {
        
        @Override
        public void registerListener(AnimationListener listener) {
        }
        
        @Override
        public void unregisterListener(AnimationListener listener) {
        }
    }
    
    private class Playing extends State {
        
        final Iterator<Animation> it = animations.iterator();
        Animation current;
        
        CountDownLatch latch = new CountDownLatch(Iterables.size(animations));
        
        final AnimationListener listener = new AnimationListener() {
            
            @Override
            public void onAnimationFinish(AnimationFinish event) {
                latch.countDown();
                if (it.hasNext()) {
                    current = it.next();
                    current.play();
                } else {
                    stop();
                }
            }
            
        };
        
        public Playing() {
            for (Animation animation : animations) {
                animation.registerListener(listener);
            }
            if (it.hasNext()) {
                current = it.next();
                current.play();
            }
        }
        
        @Override
        public void awaitFinish() {
            try {
                latch.await();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                Throwables.propagate(ex);
            }
        }
        
        @Override
        public void play() {
            
        }
        
        @Override
        public void stop() {
            state = new Stopped();
            int size = size(animations);
            for (int i = 0; i < size; ++i) {
                latch.countDown();
            }
            for (Animation animation : animations) {
                animation.unregisterListener(listener);
            }
            bus.post(new AnimationFinish(Chain.this));
        }
        
    }
    
    private class Stopped extends State {
        
        @Override
        public void awaitFinish() {
        }
        
        @Override
        public void play() {
            state = new Playing();
        }
        
        @Override
        public void stop() {
        }
        
    }
}
