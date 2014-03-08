package com.impaq.arena.player;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.impaq.arena.player.Wizards;

public class WizardsTest {

	Wizards wizards;

	@Before
	public void initialize() {
		wizards = new Wizards(2, 1);
	}

	@Test
	public void wizards_can_be_added(){
		wizards.add(1);
		Assert.assertEquals(3, wizards.getCount());
	}
	
	@Test
	public void numer_of_wizards_is_positive() {
		assertTrue(wizards.getCount() >= 0);
		wizards.kill(10);
		assertTrue(wizards.getCount() == 0);
	}

	@Test
	public void if_kill_wizard_number_of_wizards_is_less_1(){
		wizards.kill(1);
		Assert.assertEquals(1, wizards.getCount());
	}
	
	@Test
	public void two_wizards_cant_kill_enemy(){
		Assert.assertEquals(0, wizards.getStrength());
	}

	@Test
	public void four_wizards_cant_kill_enemy(){
		wizards.add(2);
		Assert.assertEquals(0, wizards.getStrength());
	}
	
	@Test
	public void five_wizards_can_kill_one_enemy(){
		wizards.add(3);
		Assert.assertEquals(1, wizards.getStrength());
	}
	
}
