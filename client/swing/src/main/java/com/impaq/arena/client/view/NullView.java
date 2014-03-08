package com.impaq.arena.client.view;

import com.impaq.arena.server.engine.GameBoardView;
import com.impaq.arena.server.event.RecruitBuilders;
import com.impaq.arena.server.event.RecruitWarriors;
import com.impaq.arena.server.event.RecruitWizards;
import com.impaq.arena.server.event.BuildCastle;
import com.impaq.arena.server.event.AttackCastle;
import com.impaq.arena.server.event.GameEnd;
import com.impaq.arena.server.event.GameStarted;
import com.impaq.arena.server.event.AttackBuilders;
import com.impaq.arena.server.event.AttackWarriors;
import com.impaq.arena.server.event.AttackWizards;
import com.impaq.arena.server.event.PlayerTurnStart;
import com.impaq.arena.server.event.RoundStart;
import com.impaq.arena.server.event.SpyBuilders;
import com.impaq.arena.server.event.SpyCastle;
import com.impaq.arena.server.event.SpyWarriors;
import com.impaq.arena.server.event.SpyWizards;

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
