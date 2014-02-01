package com.impaq.arena;

import com.google.common.eventbus.Subscribe;
import com.impaq.arena.engine.event.GameStarted;

public interface GameBoardView {

    @Subscribe
    void onGameStart(GameStarted event);

}
