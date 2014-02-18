package com.impaq.arena.view.swing;

import com.impaq.arena.engine.event.GameStarted;
import com.impaq.arena.GameBoardView;
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
    }

    @Override
    public void onWinner(Winner winner) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onSpyBuilders(SpyBuilders event) {
    }

}
