package com.impaq.arena.server.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class SpyCastle extends BaseEvent implements SpyAction{

    public SpyCastle(Player oponent) {
        super(oponent);
    }


}
