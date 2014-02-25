package com.impaq.arena.event;

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
