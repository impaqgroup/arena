package com.impaq.arena.player;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.impaq.arena.engine.Property;
import com.impaq.arena.rounds.impl.EmptyRoundManager;

public class PlayerTest {

	private Player player;
	private Property mockedProperty = mock(Property.class);
	Random numberGenerator = new Random();

	@Before
	public void player_class_exists() {
		player = new Player(new EmptyRoundManager());
	}

	@Test
	public void player_have_castle() {
		player.getCastle();
	}

	@Test
	public void player_castle_is_not_null() {
		Assert.assertNotNull(player.getCastle());
	}

	@Test
	public void player_win_when_castle_is_maximum() {
		player.getCastle().destroy(5L);
		Assert.assertFalse(player.isWinner());
		player.getCastle().expand(100L);
		Assert.assertTrue(player.isWinner());
	}

	@Test
	public void player_lose_when_castle_is_minimum() {
		player.getCastle().expand(5L);
		Assert.assertFalse(player.isLoser());
		player.getCastle().destroy(100L);
		Assert.assertTrue(player.isLoser());
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
		Assert.assertNotNull(player.getRoundManager());
	}

	@Test
	public void fist_player_have_other_round_manager_than_second() {
		Player secondPlayer = new Player(new EmptyRoundManager());
		Assert.assertNotSame(secondPlayer.getRoundManager(),
				player.getRoundManager());
	}

	@Test
	public void player_can_be_set_by_default_values_from_properties() {
		int buildersStartCount = numberGenerator.nextInt();
		when(mockedProperty.getProperty(PropertyNames.BUILDERS_START_COUNT)).thenReturn(
				String.valueOf(buildersStartCount));
		int warriorsStartCount = numberGenerator.nextInt();
		when(mockedProperty.getProperty(PropertyNames.WARRIORS_START_COUNT)).thenReturn(
				String.valueOf(warriorsStartCount));
		int wizardsStartCount = numberGenerator.nextInt();
		when(mockedProperty.getProperty(PropertyNames.WIZARDS_START_COUNT)).thenReturn(
				String.valueOf(wizardsStartCount));

		double buildersProductivity = numberGenerator.nextDouble();
		when(mockedProperty.getProperty(PropertyNames.BUILDERS_PRODUCTIVITY)).thenReturn(
				String.valueOf(buildersProductivity));
		double wizardsStrength = numberGenerator.nextDouble();
		when(mockedProperty.getProperty(PropertyNames.WIZARDS_STRENGTH)).thenReturn(
				String.valueOf(wizardsStrength));
		double warriorsStrength = numberGenerator.nextDouble();
		when(mockedProperty.getProperty(PropertyNames.WARRIORS_STRENGTH)).thenReturn(
				String.valueOf(warriorsStrength));

		int castleMaxHeight = numberGenerator.nextInt();
		when(mockedProperty.getProperty(PropertyNames.CASTLE_MAX_HEIGHT)).thenReturn(
				String.valueOf(castleMaxHeight));
		int castleStartHeight = numberGenerator.nextInt();
		when(mockedProperty.getProperty(PropertyNames.CASTLE_START_HEIGHT)).thenReturn(
				String.valueOf(castleStartHeight));

		player.setDefaults(mockedProperty);
		Assert.assertEquals(buildersStartCount, player.getBuilders().getCount());
		Assert.assertEquals(warriorsStartCount, player.getWarriors().getCount());
		Assert.assertEquals(wizardsStartCount, player.getWizards().getCount());
		Assert.assertEquals((int) Math.floor(player.getBuilders().getCount()
				* buildersProductivity), player.getBuilders().getProductivity());
		Assert.assertEquals(
				(int) Math.floor(player.getWizards().getCount()
						* wizardsStrength), player.getWizards().getStrength());
		Assert.assertEquals(
				(int) Math.floor(player.getWarriors().getCount()
						* warriorsStrength), player.getWarriors().getStrength());
		Assert.assertEquals(castleMaxHeight, player.getCastle().getMaxHeight());
		Assert.assertEquals(castleStartHeight, player.getCastle().getHeight());
	}
}
