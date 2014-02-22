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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public void onBuildCastel(BuildCastle event) {
        view.updateCastels();
    }

    @Override
    public void onDestroyCastel(DestroyCastle event) {
        view.updateCastels();
    }

}
