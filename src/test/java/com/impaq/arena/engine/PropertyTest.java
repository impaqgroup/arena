package com.impaq.arena.engine;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class PropertyTest {

	Property property;

	@Before
	public void property_class_exists() {
		property = new Property();
	}

	@Test
	public void can_load_property_test_from_property_file() {
		Assert.assertEquals("testProperty",
				property.getProperty("forJUnitTest"));
	}
}
