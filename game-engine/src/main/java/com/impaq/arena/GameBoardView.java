package com.impaq.arena;

import com.google.common.eventbus.Subscribe;
import com.impaq.arena.event.AttackBuilders;
import com.impaq.arena.event.AttackWarriors;
import com.impaq.arena.event.AttackWizards;
import com.impaq.arena.event.RecruitBuilders;
import com.impaq.arena.event.RecruitWarriors;
import com.impaq.arena.event.RecruitWizards;
import com.impaq.arena.event.BuildCastle;
import com.impaq.arena.event.AttackCastle;
import com.impaq.arena.event.GameEnd;
import com.impaq.arena.event.GameStarted;
import com.impaq.arena.event.PlayerTurnStart;
import com.impaq.arena.event.RoundStart;
import com.impaq.arena.event.SpyBuilders;
import com.impaq.arena.event.SpyCastle;
import com.impaq.arena.event.SpyWarriors;
import com.impaq.arena.event.SpyWizards;

public interface GameBoardView {

    @Subscribe
    void onGameStart(GameStarted event);

    @Subscribe
    void onRoundStart(RoundStart event);

    @Subscribe
    void onPlayerTurnStart(PlayerTurnStart event);

    @Subscribe
    void onSpyWizards(SpyWizards event);

    @Subscribe
    void onSpyWarriors(SpyWarriors event);

    @Subscribe
    void onSpyCastle(SpyCastle event);

    @Subscribe
    void onSpyBuilders(SpyBuilders event);

    @Subscribe
    void onBuildCastle(BuildCastle event);

    @Subscribe
    void onAttackCastle(AttackCastle event);

    @Subscribe
    void onAttackBuilders(AttackBuilders event);

    @Subscribe
    void onAttackWizards(AttackWizards event);

    @Subscribe
    void onAttackWarriors(AttackWarriors event);

    @Subscribe
    void onRecruitBuilders(RecruitBuilders event);

    @Subscribe
    void onRecruitWizards(RecruitWizards event);

    @Subscribe
    void onRecruitWarriors(RecruitWarriors event);

    @Subscribe
    void onGameEnd(GameEnd gameEnd);

}
