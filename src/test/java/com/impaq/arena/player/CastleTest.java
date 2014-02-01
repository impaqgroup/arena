package com.impaq.arena.player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.impaq.arena.player.Castle;

public class CastleTest {

	Castle castle;

	@Before
	public void initializeCastleTest() {
		castle = new Castle(100,25);
	}

	@Test
	public void castle_have_height() {
		Assert.assertNotNull(castle.getHeight());
	}

	@Test
	public void castle_start_with_25_height() {
		Assert.assertEquals(25, castle.getHeight());
	}

	@Test
	public void castle_can_be_expand() {
		castle.expand(10);
		Assert.assertEquals(35, castle.getHeight());
	}

	@Test
	public void maximum_of_castle_height_is_100() {
		castle.expand(110);
		Assert.assertEquals(100, castle.getHeight());
	}

	@Test
	public void castle_can_be_destroy() {
		castle.destroy(10);
		Assert.assertEquals(15, castle.getHeight());
	}

	@Test
	public void minimum_of_castle_height_is_0() {
		castle.destroy(110);
		Assert.assertEquals(0, castle.getHeight());
	}

	@Test
	public void if_castle_is_100_castle_is_maximum() {
		castle.expand(100);
		Assert.assertTrue(castle.isMax());
	}

	@Test
	public void if_castle_is_not_100_height_castle_is_not_maximum() {
		castle.destroy(5);
		Assert.assertFalse(castle.isMax());
	}

	@Test
	public void if_castle_is_100_castle_is_minimum() {
		castle.destroy(100);
		Assert.assertTrue(castle.isMin());
	}

	@Test
	public void if_castle_is_not_100_height_castle_is_not_minimum() {
		castle.expand(5);
		Assert.assertFalse(castle.isMin());
	}
}
