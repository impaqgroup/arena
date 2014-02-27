package com.impaq.arena.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class DestroyCastle extends BaseActionEvent implements OffensiveAction {

    public DestroyCastle(Player oponent, int value) {
        super(oponent, value);
    }

}
