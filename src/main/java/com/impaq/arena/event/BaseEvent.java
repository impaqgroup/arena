package com.impaq.arena.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
abstract class BaseEvent implements Event{

    private final Player player;

    public BaseEvent(Player oponent) {
        this.player = oponent;
    }

    public Player getPlayer() {
        return player;
    }

}
