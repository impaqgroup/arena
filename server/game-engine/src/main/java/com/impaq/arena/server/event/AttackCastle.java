package com.impaq.arena.server.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class AttackCastle extends BaseActionEvent implements OffensiveAction {

    public AttackCastle(Player oponent, int value) {
        super(oponent, value);
    }

}
