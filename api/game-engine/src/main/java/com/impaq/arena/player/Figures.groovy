package com.impaq.arena.player;

class Figures {

    private int count;

    Figures(int startCount) {
        count = startCount;
    }

    int getCount() {
        return count;
    }

    void kill(int count) {
        this.count -= count;
        if (this.count < 0) {
            this.count = 0;
        }
    }

    void add(int count) {
        this.count += count;
    }

    int spy() {
        return getCount();
    }
}
