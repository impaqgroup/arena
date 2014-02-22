package com.impaq.arena.engine;

import com.impaq.arena.RoundStrategy;
import com.impaq.arena.GameBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.impaq.arena.rounds.impl.EmptyRoundStrategy;
import com.impaq.arena.RoundRobinStrategy;

public class EngineTest {

    private GameBoard board;
    private RoundRobinStrategy firstPlayerRoundManager;
    private RoundRobinStrategy secondPlayerRoundManager;

    @Before
    public void engine_class_exists() {
        firstPlayerRoundManager = new RoundRobinStrategy();
        secondPlayerRoundManager = new RoundRobinStrategy();
        board = new GameBoard(firstPlayerRoundManager, secondPlayerRoundManager);
    }


    @Test
    public void first_player_win_when_build_castle() {
        firstPlayerRoundManager.add(new RoundStrategy() {

            public void body() {
                buildCastle();
            }
        });
        secondPlayerRoundManager.add(new EmptyRoundStrategy());
        board.startGame();

        Assert.assertTrue(board.getFirstPlayer().isWinner());
        Assert.assertFalse(board.getFirstPlayer().isLoser());
        Assert.assertFalse(board.getSecondPlayer().isLoser());
        Assert.assertFalse(board.getSecondPlayer().isWinner());
    }

    @Test
    public void second_player_is_looser_when_player_one_destroy_castle() {
        firstPlayerRoundManager.add(new RoundStrategy() {

            public void body() {
                destroyCastle();
            }
        });
        secondPlayerRoundManager.add(new EmptyRoundStrategy());
        board.startGame();

        Assert.assertFalse(board.getFirstPlayer().isWinner());
        Assert.assertFalse(board.getFirstPlayer().isLoser());
        Assert.assertTrue(board.getSecondPlayer().isLoser());
        Assert.assertFalse(board.getSecondPlayer().isWinner());
    }

    @Test
    public void first_player_lose_when_his_castle_is_destroy() {
        secondPlayerRoundManager.add(new RoundStrategy() {

            public void body() {
                destroyCastle();
            }
        });
        firstPlayerRoundManager.add(new EmptyRoundStrategy());
        board.startGame();

        Assert.assertFalse(board.getFirstPlayer().isWinner());
        Assert.assertTrue(board.getFirstPlayer().isLoser());
        Assert.assertFalse(board.getSecondPlayer().isLoser());
        Assert.assertFalse(board.getSecondPlayer().isWinner());
    }

    @Test
    public void second_player_win_when_build_castle() {
        secondPlayerRoundManager.add(new RoundStrategy() {

            public void body() {
                buildCastle();
            }
        });
        firstPlayerRoundManager.add(new EmptyRoundStrategy());
        board.startGame();

        Assert.assertFalse(board.getFirstPlayer().isWinner());
        Assert.assertFalse(board.getFirstPlayer().isLoser());
        Assert.assertFalse(board.getSecondPlayer().isLoser());
        Assert.assertTrue(board.getSecondPlayer().isWinner());
    }
}
