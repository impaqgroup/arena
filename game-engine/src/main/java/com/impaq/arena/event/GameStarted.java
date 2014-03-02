package com.impaq.arena.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author jaro
 */
public class GameStarted {

    private final Player playerOne;
    private final Player playerTwo;

    public GameStarted(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

}
