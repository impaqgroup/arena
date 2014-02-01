package com.impaq.arena.player;

public class Builders extends Figures {

    protected double productivity;

    public Builders(int startCount, double productivity) {
        super(startCount);
        this.productivity = productivity;
    }

    public int getProductivity() {
        return (int) Math.floor(this.getCount() * productivity);
    }

}
