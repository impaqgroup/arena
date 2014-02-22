package com.impaq.arena.player;

import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.impaq.arena.RoundRobinStrategy;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class PlayerTest {

    private Player player;

    private Builders builders = mock(Builders.class);

    private Castle castle = mock(Castle.class);

    private Wizards wizards = mock(Wizards.class);

    private Warriors warriors = mock(Warriors.class);

    Random numberGenerator = new Random();

    @Before
    public void player_class_exists() {
        player = new Player(new RoundRobinStrategy(), castle, builders, wizards, warriors);
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
        Assert.assertNotNull(player.getBuilders());
    }

    @Test
    public void player_have_wizards() {
        Assert.assertNotNull(player.getWizards());
    }

    @Test
    public void player_have_warriors() {
        Assert.assertNotNull(player.getWarriors());
    }

    @Test
    public void player_have_round_manager() {
        Assert.assertNotNull(player.getStrategy());
    }


}
