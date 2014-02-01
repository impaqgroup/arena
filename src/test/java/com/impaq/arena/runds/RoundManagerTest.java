package com.impaq.arena.runds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.impaq.arena.RoundStrategy;
import com.impaq.arena.rounds.impl.EmptyRoundStrategy;
import com.impaq.arena.rounds.impl.DefaultRoundManager;

public class RoundManagerTest {

    DefaultRoundManager roundManager;

    @Before
    public void initialize() {
        roundManager = new DefaultRoundManager();
    }

    @Test
    public void get_next_return_rund() {
        roundManager.add(new EmptyRoundStrategy());
        RoundStrategy round = roundManager.next();
    }

    @Test
    public void get_next_return_next_rund() {
        EmptyRoundStrategy round1 = new EmptyRoundStrategy();
        EmptyRoundStrategy round2 = new EmptyRoundStrategy();
        roundManager.add(round1);
        roundManager.add(round2);
        Assert.assertSame(round1, roundManager.next());
        Assert.assertSame(round2, roundManager.next());
    }

    @Test
    public void get_next_return_first_round_when_actual_round_is_last() {
        EmptyRoundStrategy round1 = new EmptyRoundStrategy();
        EmptyRoundStrategy round2 = new EmptyRoundStrategy();
        roundManager.add(round1);
        roundManager.add(round2);
        Assert.assertSame(round1, roundManager.next());
        Assert.assertSame(round2, roundManager.next());
        Assert.assertSame(round1, roundManager.next());
    }

}
