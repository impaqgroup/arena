package com.impaq.arena.server.event;

import com.impaq.arena.player.Player;

/**
 * @author jaro
 */
public class GameEnd {

    private final Player winner;

    public GameEnd(Player winner) {
        this.winner = winner;
    }

    public Player getWinner() {
        return winner;
    }

}
