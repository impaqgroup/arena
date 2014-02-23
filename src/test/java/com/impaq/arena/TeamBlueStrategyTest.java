package com.impaq.arena;

import org.junit.Test;

public class TeamBlueStrategyTest extends BaseStrategyTest {

	@Override
	public Strategy getStrategy() {
		return new TeamBlueStrategy();
	}

	@Test
	public void second_round_if_oponent_builders_more_than_wizzards_kill_builders(){
		//given
			gameBoard.setOponentBuilders(8).setWizzards(2);
		
		//when
			gameBoard.executeRound(2);
		
		//than
			assertExpectedActions(AddBuilders(), AddBuilders(), SpyBuilders(), KillBuilders() );
	}

}
