package com.impaq.arena.engine.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class KillWizards extends BaseActionEvent {

    public KillWizards(Player oponent, int value) {
        super(oponent, value);
    }

}
