package com.impaq.arena.player;

public class Castle {

    protected int maxHeight;
    private int height = 25;

    public Castle(int maxHeight, int height) {
        this.maxHeight = maxHeight;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void expand(int height) {
        this.height += height;
        if (this.height > maxHeight) {
            this.height = maxHeight;
        }
    }

    public void destroy(int height) {
        this.height -= height;
        if (this.height < 0) {
            this.height = 0;
        }
    }

    public boolean isMax() {
        return height == maxHeight;
    }

    public boolean isMin() {
        return height == 0;
    }

    public int spy() {
        return getHeight();
    }
}
