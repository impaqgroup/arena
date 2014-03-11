package com.impaq.arena.player;

import org.junit.Assert;
import org.junit.Test;

public class CastleTest {

	Castle castle = new Castle(25, 100);

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
	public void should_be_max_if_heght_more_then_100() {
		castle.expand(110);
		Assert.assertTrue(castle.isMax());
	}

	@Test
	public void castle_can_be_destroy() {
		castle.destroy(10);
		Assert.assertEquals(15, castle.getHeight());
	}

	@Test
	public void should_be_min_if_height_less_then_0() {
		castle.destroy(110);
		Assert.assertTrue(castle.isMin());
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
