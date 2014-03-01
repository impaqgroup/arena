package com.impaq.arena.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class KillWarriors extends BaseActionEvent implements OffensiveAction {

    public KillWarriors(Player oponent, int value) {
        super(oponent, value);
    }

}
