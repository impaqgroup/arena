package com.impaq.arena.server.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class SpyBuilders extends BaseEvent implements SpyAction {

    public SpyBuilders(Player oponent) {
        super(oponent);
    }

}
