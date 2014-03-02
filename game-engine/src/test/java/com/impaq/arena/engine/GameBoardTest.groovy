package com.impaq.arena.engine;

import static com.impaq.arena.api.TestStrategies.idleStrategy;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.impaq.arena.GameBoard;
import com.impaq.arena.GameBoardView
import com.impaq.arena.api.Game;
import com.impaq.arena.api.PlayerStrategy;

public class GameBoardTest {

    private GameBoard board;

    @Test
    public void first_player_win_when_build_castle() {
        board = new GameBoard(
            "one", { Game game -> game.buildMyCastle() } as PlayerStrategy,
            "two", idleStrategy);
        board.startGame();

        Assert.assertTrue(board.getFirstPlayer().isWinner());
        Assert.assertFalse(board.getFirstPlayer().isLoser());
        Assert.assertFalse(board.getSecondPlayer().isLoser());
        Assert.assertFalse(board.getSecondPlayer().isWinner());
    }

    @Test
    public void second_player_is_looser_when_player_one_destroy_castle() {
        board = new GameBoard(
            "one", { Game game -> game.attackEnemyCastle() } as PlayerStrategy,
            "two", idleStrategy);
        board.startGame();

        Assert.assertFalse(board.getFirstPlayer().isWinner());
        Assert.assertFalse(board.getFirstPlayer().isLoser());
        Assert.assertTrue(board.getSecondPlayer().isLoser());
        Assert.assertFalse(board.getSecondPlayer().isWinner());
    }

    @Test
    public void second_player_win_when_build_castle() {
        board = new GameBoard(
            "one", idleStrategy,
            "two", { Game game -> game.buildMyCastle() } as PlayerStrategy);
        board.startGame();

        Assert.assertFalse(board.getFirstPlayer().isWinner());
        Assert.assertFalse(board.getFirstPlayer().isLoser());
        Assert.assertFalse(board.getSecondPlayer().isLoser());
        Assert.assertTrue(board.getSecondPlayer().isWinner());
    }
    
    @Test
    public void shoudStopGameWhenMaxRoundNumberExceeded(){
        
        //given
        GameBoardView view = Mockito.mock(GameBoardView.class);
        board = new GameBoard("one", idleStrategy, "two", idleStrategy);
        //when
        board.registerView(view);
        board.startGame();
        //then
        
        Mockito.verify(view,Mockito.times(50)).onRoundStart(Mockito.any());
        Assert.assertFalse(board.getFirstPlayer().isWinner());
        Assert.assertFalse(board.getFirstPlayer().isLoser());
        Assert.assertFalse(board.getSecondPlayer().isLoser());
        Assert.assertFalse(board.getSecondPlayer().isWinner());
        
    }
    
    
}
