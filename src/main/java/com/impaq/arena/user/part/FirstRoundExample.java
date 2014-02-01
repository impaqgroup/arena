package com.impaq.arena.user.part;

import com.impaq.arena.RoundStrategy;

public class FirstRoundExample extends RoundStrategy {

	public void body() {
	    budujZamek();
	    if (wysokoscZamkuWroga() > 60)
		zniszczZamekWroga();
	    else 
		budujZamek();
	}

}
