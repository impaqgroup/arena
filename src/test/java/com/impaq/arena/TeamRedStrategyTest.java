package com.impaq.arena;

import org.junit.Test;

public class TeamRedStrategyTest extends BaseStrategyTest {

	@Override
	public Strategy getStrategy() {
		return new TeamRedStrategy();
	}

	@Test
	public void kill_builders_if_more_then_15(){
		//given
			gameBoard.setOponentBuilders(16);
		
		//when
			gameBoard.executeRound();
		
		//than
			assertExpectedActions(SpyBuilders(), AddWizards(), AddWizards(), KillBuilders() );
	}

	@Test
	public void destroy_castle_if_less_then_15_builders(){
		//given
			gameBoard.setOponentBuilders(10);
		
		//when
			gameBoard.executeRound();
		
		//than
			assertExpectedActions(SpyBuilders(), AddWarriors(), AddWarriors(), DestroyCastle() );
	}
	
}
