package com.impaq.arena.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class RecruitWizards extends BaseActionEvent implements AddAction{

    public RecruitWizards(Player oponent, int value) {
        super(oponent, value);
    }

}
