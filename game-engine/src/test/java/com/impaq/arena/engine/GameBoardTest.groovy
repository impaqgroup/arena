package com.impaq.arena.engine;

import static com.impaq.arena.api.TestStrategies.idleStrategy;

import org.junit.Assert;
import org.junit.Test;

import com.impaq.arena.GameBoard;
import com.impaq.arena.api.Game;
import com.impaq.arena.api.PlayerStrategy;

public class GameBoardTest {

    private GameBoard board;

    @Test
    public void first_player_win_when_build_castle() {
        board = new GameBoard(
                { Game game -> game.buildMyCastle() } as PlayerStrategy,
                idleStrategy);
        board.startGame();

        Assert.assertTrue(board.getFirstPlayer().isWinner());
        Assert.assertFalse(board.getFirstPlayer().isLoser());
        Assert.assertFalse(board.getSecondPlayer().isLoser());
        Assert.assertFalse(board.getSecondPlayer().isWinner());
    }

    @Test
    public void second_player_is_looser_when_player_one_destroy_castle() {
        board = new GameBoard(
                { Game game -> game.attackEnemyCastle() } as PlayerStrategy,
                idleStrategy);
        board.startGame();

        Assert.assertFalse(board.getFirstPlayer().isWinner());
        Assert.assertFalse(board.getFirstPlayer().isLoser());
        Assert.assertTrue(board.getSecondPlayer().isLoser());
        Assert.assertFalse(board.getSecondPlayer().isWinner());
    }

    @Test
    public void second_player_win_when_build_castle() {
        board = new GameBoard(
                idleStrategy,
                { Game game -> game.buildMyCastle() } as PlayerStrategy);
        board.startGame();

        Assert.assertFalse(board.getFirstPlayer().isWinner());
        Assert.assertFalse(board.getFirstPlayer().isLoser());
        Assert.assertFalse(board.getSecondPlayer().isLoser());
        Assert.assertTrue(board.getSecondPlayer().isWinner());
    }
}
