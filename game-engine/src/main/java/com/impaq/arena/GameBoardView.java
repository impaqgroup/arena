package com.impaq.arena;

import com.google.common.eventbus.Subscribe;
import com.impaq.arena.event.AddBuilders;
import com.impaq.arena.event.AddWarriors;
import com.impaq.arena.event.AddWizards;
import com.impaq.arena.event.BuildCastle;
import com.impaq.arena.event.DestroyCastle;
import com.impaq.arena.event.GameStarted;
import com.impaq.arena.event.KillBuilders;
import com.impaq.arena.event.KillWarriors;
import com.impaq.arena.event.KillWizards;
import com.impaq.arena.event.RoundStart;
import com.impaq.arena.event.SpyBuilders;
import com.impaq.arena.event.SpyCastle;
import com.impaq.arena.event.SpyWarriors;
import com.impaq.arena.event.SpyWizards;
import com.impaq.arena.event.Winner;

public interface GameBoardView {

    @Subscribe
    void onGameStart(GameStarted event);

    @Subscribe
    void onWinner(Winner winner);

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
    void onDestroyCastel(DestroyCastle event);

    @Subscribe
    void onKillBuilders(KillBuilders event);

    @Subscribe
    void onKillWizards(KillWizards event);

    @Subscribe
    void onKillWarriors(KillWarriors event);

    @Subscribe
    void onAddBuilders(AddBuilders event);

    @Subscribe
    void onAddWizards(AddWizards event);

    @Subscribe
    void onAddWarriors(AddWarriors event);

    @Subscribe
    void onRoundStart(RoundStart event);

}
