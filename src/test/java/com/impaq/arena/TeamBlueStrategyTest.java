package com.impaq.arena;

import static org.junit.Assert.*;

import org.junit.Test;

import com.impaq.arena.engine.event.AddBuilders;
import com.impaq.arena.engine.event.AddWizards;
import com.impaq.arena.engine.event.KillBuilders;
import com.impaq.arena.engine.event.SpyBuilders;

public class TeamBlueStrategyTest extends AbstractStrategyTest {

	@Override
	public Strategy getStrategy() {
		return new TeamBlueStrategy();
	}

	@Test
	public void second_round_if_oponent_builders_more_than_wizzards_kill_builders(){
		//given
			gameBoard.setOponentBuildersCount(8).setWizzardsCount(2);
		
		//when
			gameBoard.executeRound(2);
		
		//than
			AssertionTest(AddBuilders.class, AddBuilders.class, SpyBuilders.class, KillBuilders.class );
	}

}
