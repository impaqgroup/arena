package com.impaq.arena.server.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
abstract class BaseEvent implements Event{

    private final Player player;

    public BaseEvent(Player current) {
        this.player = current;
    }

    public Player getPlayer() {
        return player;
    }

}
