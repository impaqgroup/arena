package com.impaq.arena.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class RecruitWarriors extends BaseActionEvent implements AddAction{

    public RecruitWarriors(Player oponent, int value) {
        super(oponent, value);
    }

}
