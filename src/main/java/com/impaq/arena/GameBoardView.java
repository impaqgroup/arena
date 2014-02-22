package com.impaq.arena;

import com.google.common.eventbus.Subscribe;
import com.impaq.arena.engine.event.BuildCastle;
import com.impaq.arena.engine.event.DestroyCastle;
import com.impaq.arena.engine.event.GameStarted;
import com.impaq.arena.engine.event.SpyBuilders;
import com.impaq.arena.engine.event.SpyCastle;
import com.impaq.arena.engine.event.SpyWarriors;
import com.impaq.arena.engine.event.SpyWizards;
import com.impaq.arena.engine.event.Winner;

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
    void onSpyCastel(SpyCastle event);

    @Subscribe
    void onSpyBuilders(SpyBuilders event);

    @Subscribe
    void onBuildCastel(BuildCastle event);
    
    @Subscribe
    void onDestroyCastel(DestroyCastle event);

}
