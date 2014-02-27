package com.impaq.arena.view.swing.common.animation;

import com.google.common.base.Throwables;
import static com.google.common.collect.ImmutableList.copyOf;
import com.google.common.collect.Iterables;
import static com.google.common.collect.Iterables.size;
import com.google.common.eventbus.EventBus;
import com.impaq.arena.view.swing.common.Animation;
import com.impaq.arena.view.swing.common.AnimationFinish;
import com.impaq.arena.view.swing.common.AnimationListener;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class Parallel implements Animation {

    public static Animation of(Animation animation) {
        return animation;
    }

    public static Animation of(Animation... animations) {
        return new Parallel(animations);
    }

    private final Iterable<Animation> animations;
    private final EventBus bus = new EventBus();
    private State state = new Stopped();

    public Parallel(Animation... animations) {
        this(copyOf(animations));
    }

    public Parallel(Iterable<Animation> animations) {
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

        public Playing() {
        }

        @Override
        public void awaitFinish() {
            for (Animation animation : animations) {
                animation.awaitFinish();
            }
        }

        @Override
        public void play() {

        }

        @Override
        public void stop() {
            state = new Stopped();
            for (Animation animation : animations) {
                animation.stop();
            }
            bus.post(new AnimationFinish(Parallel.this));
        }

    }

    private class Stopped extends State {

        @Override
        public void awaitFinish() {
        }

        @Override
        public void play() {
            for (Animation animation : animations) {
                animation.play();
            }
            state = new Playing();

        }

        @Override
        public void stop() {
        }

    }

}
