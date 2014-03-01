package com.impaq.arena.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author jaro
 */
public class Winner  {

    private final Player winner;

    public Winner(Player winner) {
        this.winner = winner;
    }

    public Player getWinner() {
        return winner;
    }

}
