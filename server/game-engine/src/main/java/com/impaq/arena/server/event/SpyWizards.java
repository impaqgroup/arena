package com.impaq.arena.server.event;

import com.impaq.arena.player.Player;

/**
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class SpyWizards extends BaseEvent implements SpyAction {

    public SpyWizards(Player current) {
        super(current);
    }

}
