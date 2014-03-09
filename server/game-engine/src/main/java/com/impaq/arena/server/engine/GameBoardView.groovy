package com.impaq.arena.server.engine;

import com.google.common.eventbus.Subscribe;
import com.impaq.arena.server.event.AttackBuilders;
import com.impaq.arena.server.event.AttackWarriors;
import com.impaq.arena.server.event.AttackWizards;
import com.impaq.arena.server.event.RecruitBuilders;
import com.impaq.arena.server.event.RecruitWarriors;
import com.impaq.arena.server.event.RecruitWizards;
import com.impaq.arena.server.event.BuildCastle;
import com.impaq.arena.server.event.AttackCastle;
import com.impaq.arena.server.event.GameEnd;
import com.impaq.arena.server.event.GameStarted;
import com.impaq.arena.server.event.PlayerTurnStart;
import com.impaq.arena.server.event.RoundStart;
import com.impaq.arena.server.event.SpyBuilders;
import com.impaq.arena.server.event.SpyCastle;
import com.impaq.arena.server.event.SpyWarriors;
import com.impaq.arena.server.event.SpyWizards;

interface GameBoardView {

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
