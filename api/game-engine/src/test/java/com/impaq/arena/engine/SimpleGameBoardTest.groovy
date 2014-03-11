package com.impaq.arena.engine

import com.impaq.arena.api.Game
import com.impaq.arena.api.PlayerStrategy
import org.junit.Assert
import org.junit.Test

public class SimpleGameBoardTest {

    PlayerStrategy idleStrategy = { Game game -> } as PlayerStrategy

    private GameConfig gameConfig = new DefaultGameConfig()
    private SimpleGameBoard board;

    @Test
    public void first_player_win_when_build_castle() {
        board = new SimpleGameBoard(gameConfig,
            "one", { Game game -> game.buildMyCastle() } as PlayerStrategy,
            "two", idleStrategy);
        board.playGame();

        Assert.assertTrue(board.firstPlayer().isWinner());
        Assert.assertFalse(board.firstPlayer().isLoser());
        Assert.assertFalse(board.secondPlayer().isLoser());
        Assert.assertFalse(board.secondPlayer().isWinner());
    }

    @Test
    public void second_player_is_looser_when_player_one_destroy_castle() {
        board = new SimpleGameBoard(gameConfig,
            "one", { Game game -> game.attackEnemyCastle() } as PlayerStrategy,
            "two", idleStrategy);
        board.playGame();

        Assert.assertFalse(board.firstPlayer().isWinner());
        Assert.assertFalse(board.firstPlayer().isLoser());
        Assert.assertTrue(board.secondPlayer().isLoser());
        Assert.assertFalse(board.secondPlayer().isWinner());
    }

    @Test
    public void second_player_win_when_build_castle() {
        board = new SimpleGameBoard(gameConfig,
            "one", idleStrategy,
            "two", { Game game -> game.buildMyCastle() } as PlayerStrategy);
        board.playGame();

        Assert.assertFalse(board.firstPlayer().isWinner());
        Assert.assertFalse(board.firstPlayer().isLoser());
        Assert.assertFalse(board.secondPlayer().isLoser());
        Assert.assertTrue(board.secondPlayer().isWinner());
    }
}
