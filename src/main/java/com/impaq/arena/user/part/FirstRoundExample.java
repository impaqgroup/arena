package com.impaq.arena.user.part;

import com.impaq.arena.engine.Actions;
import com.impaq.arena.rounds.IRound;

public class FirstRoundExample implements IRound {

	public void body() {
	    Actions.BudujZamek();
	    if (Actions.WysokoscZamkuWroga() > 60)
		Actions.ZniszczZamekWroga();
	    else 
		Actions.BudujZamek();
	}

}
