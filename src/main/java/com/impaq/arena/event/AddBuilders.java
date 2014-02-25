package com.impaq.arena.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class AddBuilders extends BaseActionEvent{

    public AddBuilders(Player oponent, int value) {
        super(oponent, value);
    }

}
