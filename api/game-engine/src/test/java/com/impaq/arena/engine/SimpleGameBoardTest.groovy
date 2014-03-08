package com.impaq.arena.engine

import static com.impaq.arena.api.TestStrategies.idleStrategy;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito
import com.impaq.arena.GameBoardView
import com.impaq.arena.api.Game;
import com.impaq.arena.api.PlayerStrategy;

public class SimpleGameBoardTest {

    private SimpleGameBoard board;

    @Test
    public void first_player_win_when_build_castle() {
        board = new SimpleGameBoard(
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
        board = new SimpleGameBoard(
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
        board = new SimpleGameBoard(
            "one", idleStrategy,
            "two", { Game game -> game.buildMyCastle() } as PlayerStrategy);
        board.playGame();

        Assert.assertFalse(board.firstPlayer().isWinner());
        Assert.assertFalse(board.firstPlayer().isLoser());
        Assert.assertFalse(board.secondPlayer().isLoser());
        Assert.assertTrue(board.secondPlayer().isWinner());
    }
    
    @Test
    public void shoudStopGameWhenMaxRoundNumberExceeded(){
        
        //given
        GameBoardView view = Mockito.mock(GameBoardView.class);
        board = new SimpleGameBoard("one", idleStrategy, "two", idleStrategy);
        //when
        board.registerView(view);
        board.playGame();
        //then
        
        Mockito.verify(view,Mockito.times(50)).onRoundStart(Mockito.any());
        Assert.assertFalse(board.firstPlayer().isWinner());
        Assert.assertFalse(board.firstPlayer().isLoser());
        Assert.assertFalse(board.secondPlayer().isLoser());
        Assert.assertFalse(board.secondPlayer().isWinner());
        
    }
    
    
}
