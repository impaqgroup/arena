package com.impaq.arena.user.part;

import com.impaq.arena.RoundStrategy;

public class FirstRoundExample extends RoundStrategy {

	public void body() {
	    buildCastle();
	    if (spyCastle() > 60)
		destroyCastle();
	    else 
		buildCastle();
	}

}
