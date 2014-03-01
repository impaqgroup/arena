package com.impaq.arena.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class SpyWarriors extends BaseEvent implements SpyAction{

    public SpyWarriors(Player oponent) {
        super(oponent);
    }

}
