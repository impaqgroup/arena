package com.impaq.arena.view;

import com.impaq.arena.engine.event.GameStarted;
import com.impaq.arena.GameBoardView;
import com.impaq.arena.engine.event.BuildCastle;
import com.impaq.arena.engine.event.DestroyCastle;
import com.impaq.arena.engine.event.SpyBuilders;
import com.impaq.arena.engine.event.SpyCastle;
import com.impaq.arena.engine.event.SpyWarriors;
import com.impaq.arena.engine.event.SpyWizards;
import com.impaq.arena.engine.event.Winner;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
class NullView implements GameBoardView {

    public NullView() {
    }

    @Override
    public void onGameStart(GameStarted event) {
    }

    @Override
    public void onWinner(Winner winner) {
    }

    @Override
    public void onSpyWizards(SpyWizards event) {
    }

    @Override
    public void onSpyWarriors(SpyWarriors event) {
    }

    @Override
    public void onSpyCastel(SpyCastle event) {
    }

    @Override
    public void onSpyBuilders(SpyBuilders event) {
    }

    @Override
    public void onBuildCastle(BuildCastle event) {
    }

    @Override
    public void onDestroyCastel(DestroyCastle event) {
    }

}
