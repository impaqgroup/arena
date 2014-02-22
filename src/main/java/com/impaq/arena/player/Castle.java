package com.impaq.arena.player;

public class Castle {

    private int maxHeight;
    private int height = 30;

    public Castle(int maxHeight, int height) {
        this.maxHeight = maxHeight;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void expand(int height) {
        this.height += height;
        if ( isMax() )
        	this.height = 100;
    }

    public void destroy(int height) {
        this.height -= height;
        if ( isMin() )
        	this.height = 0;
    }

    public boolean isMax() {
        return height >= maxHeight;
    }

    public boolean isMin() {
        return height <= 0;
    }

    public int spy() {
        return getHeight();
    }
}
