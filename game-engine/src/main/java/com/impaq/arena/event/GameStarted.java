package com.impaq.arena.event;

import com.impaq.arena.player.Player;

/**
 *
 * @author jaro
 */
public class GameStarted {

    private final Player left;
    private final Player right;

    public GameStarted(Player left, Player right) {
        this.left = left;
        this.right = right;
    }

    public Player getLeft() {
        return left;
    }

    public Player getRight() {
        return right;
    }

}
