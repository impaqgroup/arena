package com.impaq.arena.client.view;

import com.impaq.arena.GameBoardView;
import com.impaq.arena.event.RecruitBuilders;
import com.impaq.arena.event.RecruitWarriors;
import com.impaq.arena.event.RecruitWizards;
import com.impaq.arena.event.BuildCastle;
import com.impaq.arena.event.AttackCastle;
import com.impaq.arena.event.GameEnd;
import com.impaq.arena.event.GameStarted;
import com.impaq.arena.event.AttackBuilders;
import com.impaq.arena.event.AttackWarriors;
import com.impaq.arena.event.AttackWizards;
import com.impaq.arena.event.PlayerTurnStart;
import com.impaq.arena.event.RoundStart;
import com.impaq.arena.event.SpyBuilders;
import com.impaq.arena.event.SpyCastle;
import com.impaq.arena.event.SpyWarriors;
import com.impaq.arena.event.SpyWizards;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class NullView implements GameBoardView {

    public NullView() {
    }

    @Override
    public void onGameStart(GameStarted event) {
    }

    @Override
    public void onGameEnd(GameEnd gameEnd) {
    }

    @Override
    public void onSpyWizards(SpyWizards event) {
    }

    @Override
    public void onSpyWarriors(SpyWarriors event) {
    }

    @Override
    public void onSpyCastle(SpyCastle event) {
    }

    @Override
    public void onSpyBuilders(SpyBuilders event) {
    }

    @Override
    public void onBuildCastle(BuildCastle event) {
    }

    @Override
    public void onAttackCastle(AttackCastle event) {
    }

    @Override
    public void onAttackBuilders(AttackBuilders event) {
    }

    @Override
    public void onAttackWizards(AttackWizards event) {
    }

    @Override
    public void onAttackWarriors(AttackWarriors event) {
    }

    @Override
    public void onRecruitBuilders(RecruitBuilders event) {
    }

    @Override
    public void onRecruitWizards(RecruitWizards event) {
    }

    @Override
    public void onRecruitWarriors(RecruitWarriors event) {
    }

    @Override
    public void onRoundStart(RoundStart event) {
    }

    @Override
    public void onPlayerTurnStart(PlayerTurnStart event) {

    }
}
