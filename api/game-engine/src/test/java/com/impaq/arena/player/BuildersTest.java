package com.impaq.arena.player;

import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.impaq.arena.player.Builders;

public class BuildersTest {

	Builders builders;

	@Before
	public void initialize() {
		builders = new Builders(2, 1);
	}

	@Test
	public void numer_of_builders_is_positive() {
		assertTrue(builders.getCount() >= 0);
		builders.kill(10);
		assertTrue(builders.getCount() == 0);
	}

	@Test
	public void if_kill_1_builders_number_of_builders_is_less_1() {
		builders.kill(1);
		Assert.assertEquals(1, builders.getCount());
	}

	@Test
	public void one_builder_can_build_one_point_of_castle() {
		builders.kill(1);
		Assert.assertEquals(1, builders.getProductivity());
	}
}
