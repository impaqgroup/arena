package com.impaq.arena.engine.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
abstract class BaseActionEvent  extends BaseEvent{

    private final int value;

    public BaseActionEvent(Player oponent, int value) {
        super(oponent);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
