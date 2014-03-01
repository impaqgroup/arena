package com.impaq.arena.player;

public class Warriors extends Figures {

    private double strength;

    public Warriors(int startCount, double strength) {
        super(startCount);
        this.strength = strength;
    }

    public int getStrength() {
        return (int) Math.floor(this.getCount() * strength);
    }

}
