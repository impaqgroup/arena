package com.impaq.arena.event;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class RoundStart {

    private final int number;

    public RoundStart(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
