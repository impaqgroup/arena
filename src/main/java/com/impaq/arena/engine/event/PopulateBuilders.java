package com.impaq.arena.engine.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class PopulateBuilders extends BaseActionEvent{

    public PopulateBuilders(Player oponent, int value) {
        super(oponent, value);
    }

}
