package com.impaq.arena.view;

import com.impaq.arena.engine.event.GameStarted;
import com.impaq.arena.GameBoardView;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
class EmptyVisualisation implements GameBoardView {

    public EmptyVisualisation() {
    }

    @Override
    public void onGameStart(GameStarted event) {
    }

}
