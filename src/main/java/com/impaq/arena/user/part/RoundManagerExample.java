package com.impaq.arena.user.part;

import com.impaq.arena.rounds.impl.DefaultRoundManager;

public class RoundManagerExample extends DefaultRoundManager {

	public RoundManagerExample(){
		add(new FirstRoundExample());
		add(new SecondRoundExample());
	}
	
}
