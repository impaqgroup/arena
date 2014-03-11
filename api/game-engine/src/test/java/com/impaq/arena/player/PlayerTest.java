package com.impaq.arena.player;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.impaq.arena.api.PlayerStrategy;
import com.impaq.arena.engine.DefaultGameConfig;
import com.impaq.arena.engine.GameConfig;

public class PlayerTest {

    GameConfig gameConfig = new DefaultGameConfig();

    PlayerStrategy strategy = mock(PlayerStrategy.class);

    Player player = new Player("", strategy, gameConfig);

    @Test
    public void player_win_when_castle_is_maximum() {
        assertFalse(player.isWinner());

        player.getCastle().expand(gameConfig.castleMaxHeight());
        assertTrue(player.isWinner());
    }

    @Test
    public void player_lose_when_castle_is_minimum() {
        assertFalse(player.isLoser());

        player.getCastle().destroy(player.getCastle().getHeight());
        assertTrue(player.isLoser());
    }

}
