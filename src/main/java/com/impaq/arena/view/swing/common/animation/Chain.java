package com.impaq.arena.view.swing.common.animation;

import static com.google.common.collect.ImmutableList.copyOf;
import com.google.common.collect.Iterables;
import static com.google.common.collect.Iterables.size;
import com.impaq.arena.view.swing.common.Animation;
import com.impaq.arena.view.swing.common.AnimationFinish;
import com.impaq.arena.view.swing.common.AnimationListener;
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
    private State state = new Stopped();

    public Chain(Animation... animations) {
        this(copyOf(animations));
    }

    public Chain(Iterable<Animation> animations) {
        this.animations = animations;
    }

    @Override
    public void awaitFinish() throws InterruptedException {
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
    }

    @Override
    public void unregisterListener(AnimationListener listener) {
    }

    private abstract class State implements Animation {

        @Override
        public void registerListener(AnimationListener listener) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void unregisterListener(AnimationListener listener) {
            throw new UnsupportedOperationException("Not supported yet.");
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
        public void awaitFinish() throws InterruptedException {

            latch.await();
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
        }

    }

    private class Stopped extends State {

        @Override
        public void awaitFinish() throws InterruptedException {
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
