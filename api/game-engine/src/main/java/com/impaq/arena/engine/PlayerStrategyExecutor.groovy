package com.impaq.arena.engine

import com.impaq.arena.player.Player

public interface PlayerStrategyExecutor {

    Player getPlayer()

    Player getOpponent()

    void playRound()

}