package com.impaq.arena.engine.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
abstract class BaseEvent implements Event{

    private final Player oponent;

    public BaseEvent(Player oponent) {
        this.oponent = oponent;
    }

    public Player getOponent() {
        return oponent;
    }

}
