package com.impaq.arena.view;

import com.impaq.arena.engine.event.GameStarted;
import com.impaq.arena.GameBoardView;
import com.impaq.arena.engine.event.AddBuilders;
import com.impaq.arena.engine.event.AddWarriors;
import com.impaq.arena.engine.event.AddWizards;
import com.impaq.arena.engine.event.BuildCastle;
import com.impaq.arena.engine.event.DestroyCastle;
import com.impaq.arena.engine.event.KillBuilders;
import com.impaq.arena.engine.event.KillWarriors;
import com.impaq.arena.engine.event.KillWizards;
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

    @Override
    public void onKillBuilders(KillBuilders event) {
    }

    @Override
    public void onKillWizards(KillWizards event) {
    }

    @Override
    public void onKillWarriors(KillWarriors event) {
    }

    @Override
    public void onAddBuilders(AddBuilders event) {
    }

    @Override
    public void onAddWizards(AddWizards event) {
    }

    @Override
    public void onAddWarriors(AddWarriors event) {
    }

}
