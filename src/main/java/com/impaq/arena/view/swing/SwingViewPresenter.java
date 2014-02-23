package com.impaq.arena.view.swing;

import com.impaq.arena.GameBoardView;
import com.impaq.arena.engine.event.BuildCastle;
import com.impaq.arena.engine.event.DestroyCastle;
import com.impaq.arena.engine.event.GameStarted;
import com.impaq.arena.engine.event.SpyBuilders;
import com.impaq.arena.engine.event.SpyCastle;
import com.impaq.arena.engine.event.SpyWarriors;
import com.impaq.arena.engine.event.SpyWizards;
import com.impaq.arena.engine.event.Winner;

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
        view.updateCastels();
    }

    @Override
    public void onDestroyCastel(DestroyCastle event) {
        view.updateCastels();
    }

}
