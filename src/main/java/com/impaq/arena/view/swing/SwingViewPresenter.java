package com.impaq.arena.view.swing;

import com.impaq.arena.GameBoardView;
import com.impaq.arena.event.AddBuilders;
import com.impaq.arena.event.AddWarriors;
import com.impaq.arena.event.AddWizards;
import com.impaq.arena.event.BuildCastle;
import com.impaq.arena.event.DestroyCastle;
import com.impaq.arena.event.GameStarted;
import com.impaq.arena.event.KillBuilders;
import com.impaq.arena.event.KillWarriors;
import com.impaq.arena.event.KillWizards;
import com.impaq.arena.event.SpyBuilders;
import com.impaq.arena.event.SpyCastle;
import com.impaq.arena.event.SpyWarriors;
import com.impaq.arena.event.SpyWizards;
import com.impaq.arena.event.Winner;

/**
 *
 * @author jaro
 */
public class SwingViewPresenter implements GameBoardView {

    private SwingView view = new SwingView();

    @Override
    public void onGameStart(GameStarted event) {
        view.displayIntro();
        view.initialize(event.getLeft(), event.getRight());
    }

    @Override
    public void onWinner(Winner winner) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
        }
        view.dispose();
    }

    @Override
    public void onSpyWizards(SpyWizards event) {
        view.spyWizzard(event.getPlayer());
    }

    @Override
    public void onSpyWarriors(SpyWarriors event) {
        view.spyWarriors(event.getPlayer());
    }

    @Override
    public void onSpyCastel(SpyCastle event) {
        view.spyCastel(event.getPlayer());
    }

    @Override
    public void onSpyBuilders(SpyBuilders event) {
        view.spyBuilders(event.getPlayer());
    }

    @Override
    public void onBuildCastle(BuildCastle event) {
        view.buildCastle(event.getPlayer());
        view.updateCastels();
    }

    @Override
    public void onDestroyCastel(DestroyCastle event) {
        view.destroyCastle(event.getPlayer());
        view.updateCastels();
    }

    @Override
    public void onKillBuilders(KillBuilders event) {
        view.killBuilders(event.getPlayer());
    }

    @Override
    public void onKillWizards(KillWizards event) {
        view.killWizzards(event.getPlayer());
    }

    @Override
    public void onKillWarriors(KillWarriors event) {
        view.killWarriors(event.getPlayer());
    }

    @Override
    public void onAddBuilders(AddBuilders event) {
        view.addBuilders(event.getPlayer());
    }

    @Override
    public void onAddWizards(AddWizards event) {
        view.addWizards(event.getPlayer());
    }

    @Override
    public void onAddWarriors(AddWarriors event) {
        view.addWarriors(event.getPlayer());
    }

}
