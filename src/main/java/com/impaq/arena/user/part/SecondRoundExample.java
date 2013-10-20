package com.impaq.arena.user.part;

import com.impaq.arena.engine.Actions;
import com.impaq.arena.rounds.IRound;

public class SecondRoundExample implements IRound {

	public void body() {
	    Actions.DodajWojownikow();
	    Actions.ZniszczZamekWroga();
	}

}
