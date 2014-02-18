package com.impaq.arena.user.part;

import com.impaq.arena.rounds.impl.ListStrategy;

public class RoundManagerExample extends ListStrategy {

	public RoundManagerExample(){
		add(new FirstRoundExample());
		add(new SecondRoundExample());
	}
	
}
