package com.impaq.arena.engine.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class SpyWarriors extends BaseEvent{

    public SpyWarriors(Player oponent) {
        super(oponent);
    }

}
