package com.impaq.arena.view.swing;

import com.impaq.arena.engine.event.GameStarted;
import com.impaq.arena.GameBoardView;

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

}
