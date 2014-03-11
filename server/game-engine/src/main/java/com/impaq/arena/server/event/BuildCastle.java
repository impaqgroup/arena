package com.impaq.arena.server.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class BuildCastle extends BaseActionEvent implements OffensiveAction{

    public BuildCastle(Player player, int value) {
        super(player, value);
    }


}
