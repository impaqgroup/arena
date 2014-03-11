package com.impaq.arena.player;

import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.impaq.arena.player.Warriors;

public class WarriorsTest {

	Warriors warriors;

	@Before
	public void initialize() {
		warriors = new Warriors(2, 1);
	}

	@Test
	public void numer_of_warriors_is_positive() {
		assertTrue(warriors.getCount() >= 0);
		warriors.kill(10);
		assertTrue(warriors.getCount() == 0);
	}

	@Test
	public void if_kill_1_warrior_number_of_warriors_is_less_1(){
		warriors.kill(1);
		Assert.assertEquals(1, warriors.getCount());
	}
	
	@Test
	public void one_warrior_can_destroy_one_point_of_castle(){
		warriors.kill(1);
		Assert.assertEquals(1, warriors.getStrength());
	}
	
}
