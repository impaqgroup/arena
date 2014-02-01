package com.impaq.arena.view.swing.common;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author jaro
 */
public abstract class Animation implements TimeListener {

    private long time;
    private final Stage stage;
    private final long duration;
    private State state = new StoppedState();
    private CountDownLatch finishLatch;

    public Animation(Stage stage, long duration) {
        this.stage = stage;
        this.duration = duration;
    }

    @Override
    public void update(long elapsedTime) {
        state.update(elapsedTime);

    }

    public void play() {
        state.play();
    }

    public void stop() {
        state.stop();
    }

    protected abstract void updateValue(double l);

    private void onStart() {
        stage.addTimeListener(this);
    }

    private void onFinish() {
        stage.removeTimeListener(this);
        finishLatch.countDown();
    }

    public void awaitFinish() throws InterruptedException {
        state.awaitFinish();
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
