package com.impaq.arena.user.part;

import com.impaq.arena.rounds.impl.AbstractRoundManager;

public class RoundManagerExample extends AbstractRoundManager {

	public RoundManagerExample(){
		add(new FirstRoundExample());
		add(new SecondRoundExample());
	}
	
}
