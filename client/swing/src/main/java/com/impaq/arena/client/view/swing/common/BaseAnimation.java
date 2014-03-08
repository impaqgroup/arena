package com.impaq.arena.client.view.swing.common;

import static com.google.common.base.Throwables.propagate;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author jaro
 */
public abstract class BaseAnimation implements TimeListener, Animation {

    private long time;
    private final Stage stage = Stage.get();
    private final long duration;
    private final EventBus bus = new EventBus();
    private State state = new StoppedState();
    private CountDownLatch finishLatch;

    public BaseAnimation(long duration) {
        this.duration = duration;
    }

    @Override
    public void update(long elapsedTime) {
        state.update(elapsedTime);

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

    protected abstract void updateValue(double l);

    private void onStart() {
        stage.addTimeListener(this);
    }

    private void onFinish() {
        bus.post(new AnimationFinish(this));
        stage.removeTimeListener(this);
        finishLatch.countDown();
    }

    @Override
    public void awaitFinish() {
        try {
            state.awaitFinish();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw propagate(ex);
        }

    }

    private class PlayingState implements State {

        @Override
        public void play() {
        }

        @Override
        public void stop() {
            onFinish();
            state = new StoppedState();
        }

        @Override
        public void update(long elapsedTime) {
            if ((time + elapsedTime) <= duration) {
                time += elapsedTime;
                updateValue((double) time / duration);
            } else {
                updateValue(1.0);
                onFinish();
            }
        }

        @Override
        public void awaitFinish() throws InterruptedException {
            finishLatch.await(duration + 10, TimeUnit.MILLISECONDS);
        }

    }

    private interface State extends TimeListener {

        void play();

        void stop();

        void awaitFinish() throws InterruptedException;
    }

    private class StoppedState implements State {

        @Override
        public void play() {
            time = 0;
            finishLatch = new CountDownLatch(1);
            state = new PlayingState();
            onStart();
        }

        @Override
        public void stop() {
        }

        @Override
        public void update(long elapsedTime) {
        }

        @Override
        public void awaitFinish() {
        }

    }

}
