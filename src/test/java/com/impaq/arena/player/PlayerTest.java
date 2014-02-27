package com.impaq.arena.player;

import com.impaq.arena.Strategy;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class PlayerTest {

    private Player player;

    private Builders builders = mock(Builders.class);

    private Castle castle = mock(Castle.class);

    private Wizards wizards = mock(Wizards.class);

    private Warriors warriors = mock(Warriors.class);

    private Strategy strategy = new Strategy();

    Random numberGenerator = new Random();

    @Before
    public void player_class_exists() {

        player = new Player(strategy, castle, builders, wizards, warriors);
    }

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

    @Test
    public void player_have_builders() {
        Assert.assertSame(player.getBuilders(), builders);
    }

    @Test
    public void player_have_wizards() {
        Assert.assertSame(player.getWizards(), wizards);
    }

    @Test
    public void player_have_warriors() {
        Assert.assertSame(player.getWarriors(), warriors);
    }

    @Test
    public void player_have_round_manager() {
        Assert.assertSame(player.getStrategy(), strategy);
    }

}
