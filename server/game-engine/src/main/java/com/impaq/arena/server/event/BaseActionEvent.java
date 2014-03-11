package com.impaq.arena.server.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
abstract class BaseActionEvent  extends BaseEvent{

    private final int value;

    public BaseActionEvent(Player player, int value) {
        super(player);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
