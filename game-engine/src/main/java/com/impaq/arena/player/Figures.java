package com.impaq.arena.player;

public class Figures {

    private int count;

    public Figures(int startCount) {
        count = startCount;
    }

    public int getCount() {
        return count;
    }

    public void kill(int count) {
        this.count -= count;
        if (this.count < 0) {
            this.count = 0;
        }
    }

    public void add(int count) {
        this.count += count;
    }

    public int spy() {
        return getCount();
    }
}
