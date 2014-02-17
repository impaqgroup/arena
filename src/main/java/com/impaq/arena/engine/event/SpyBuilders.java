package com.impaq.arena.engine.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class SpyBuilders extends BaseEvent {

    public SpyBuilders(Player oponent) {
        super(oponent);
    }

}
