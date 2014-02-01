package com.impaq.arena.view.swing.common;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaro
 */
class KeyFrames {

    private List<Frame> frames = new ArrayList<Frame>();

    private int currFrameIndex;

    private long animTime;

    private long totalDuration;

    /**
     * Creates a new, empty Animation.
     */
    public KeyFrames() {
        totalDuration = 0;
        animTime = 0;
        currFrameIndex = 0;
    }

    /**
     * Adds an image to the animation with the specified duration (time to
     * display the image).
     */
    public synchronized void addFrame(Image image, long duration) {
        totalDuration += duration;
        frames.add(new Frame(image, totalDuration));
    }

    public void update(long elapsedTime) {
        if (frames.size() > 1) {
            animTime += elapsedTime;

            if (animTime >= totalDuration) {
                animTime = animTime % totalDuration;
                currFrameIndex = 0;
            }

            while (animTime > getFrame(currFrameIndex).endTime) {
                currFrameIndex++;
            }
        }
    }

    /**
     * Gets this Animation's current image. Returns null if this animation has
     * no images.
     */
    public synchronized Image getImage() {
        if (frames.size() == 0) {
            return null;
        } else {
            return getFrame(currFrameIndex).image;
        }
    }

    private Frame getFrame(int i) {
        return (Frame) frames.get(i);
    }

    private class Frame {

        Image image;

        long endTime;

        public Frame(Image image, long endTime) {
            this.image = image;
            this.endTime = endTime;
        }
    }
}
