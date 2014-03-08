package com.impaq.arena.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class AttackWizards extends BaseActionEvent implements OffensiveAction {

    public AttackWizards(Player oponent, int value) {
        super(oponent, value);
    }

}
