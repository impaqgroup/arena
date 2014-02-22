package com.impaq.arena.user.part;

import com.impaq.arena.RoundRobinStrategy;

public class RoundManagerExample extends RoundRobinStrategy {

	public RoundManagerExample(){
		add(new FirstRoundExample());
		add(new SecondRoundExample());
	}
	
}
