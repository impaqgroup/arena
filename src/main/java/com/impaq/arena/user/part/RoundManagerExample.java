package com.impaq.arena.user.part;

import com.impaq.arena.rounds.impl.DefaultStrategy;

public class RoundManagerExample extends DefaultStrategy {

	public RoundManagerExample(){
		add(new FirstRoundExample());
		add(new SecondRoundExample());
	}
	
}
