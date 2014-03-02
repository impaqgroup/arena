package com.impaq.arena.player;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.impaq.arena.api.PlayerStrategy;

public class PlayerTest {

    private Builders builders = mock(Builders.class);

    private Castle castle = mock(Castle.class);

    private Wizards wizards = mock(Wizards.class);

    private Warriors warriors = mock(Warriors.class);

    private PlayerStrategy strategy = mock(PlayerStrategy.class);

    private Player player = new Player("", strategy, castle, builders, wizards, warriors);

    @Test
    public void player_win_when_castle_is_maximum() {
        assertFalse(player.isWinner());
        when(castle.isMax()).thenReturn(true);
        assertTrue(player.isWinner());
    }

    @Test
    public void player_lose_when_castle_is_minimum() {
        assertFalse(player.isLoser());
        when(castle.isMin()).thenReturn(true);
        assertTrue(player.isLoser());
    }

}
