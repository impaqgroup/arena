package com.impaq.arena.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class AddWizards extends BaseActionEvent{

    public AddWizards(Player oponent, int value) {
        super(oponent, value);
    }

}
