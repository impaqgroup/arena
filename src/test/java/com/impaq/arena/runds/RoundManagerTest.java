package com.impaq.arena.runds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.impaq.arena.rounds.IRound;
import com.impaq.arena.rounds.impl.EmptyRound;
import com.impaq.arena.rounds.impl.EmptyRoundManager;

public class RoundManagerTest {

	EmptyRoundManager roundManager;

	@Before
	public void initialize() {
		roundManager = new EmptyRoundManager();
	}

	@Test
	public void get_next_return_rund() {
		roundManager.add(new EmptyRound());
		IRound round = (IRound) roundManager.getNext();
	}

	@Test
	public void get_next_return_next_rund() {
		EmptyRound round1 = new EmptyRound();
		EmptyRound round2 = new EmptyRound();
		roundManager.add(round1);
		roundManager.add(round2);
		Assert.assertSame(round1, roundManager.getNext());
		Assert.assertSame(round2, roundManager.getNext());
	}

	@Test
	public void get_next_return_first_round_when_actual_round_is_last() {
		EmptyRound round1 = new EmptyRound();
		EmptyRound round2 = new EmptyRound();
		roundManager.add(round1);
		roundManager.add(round2);
		Assert.assertSame(round1, roundManager.getNext());
		Assert.assertSame(round2, roundManager.getNext());
		Assert.assertSame(round1, roundManager.getNext());
	}	
	
}
