package com.impaq.arena.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class RecruitBuilders extends BaseActionEvent implements AddAction{

    public RecruitBuilders(Player oponent, int value) {
        super(oponent, value);
    }

}
