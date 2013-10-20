package com.impaq.arena.rounds.impl;

import java.util.ArrayList;

import com.impaq.arena.rounds.IRound;
import com.impaq.arena.rounds.IRoundManager;

public abstract class AbstractRoundManager extends ArrayList<IRound> implements IRoundManager {

	private int actualIndex = 0;

	public IRound getNext() {
		IRound round = get(actualIndex);
		actualIndex = isLastRound() ? 0 : ++actualIndex;
		return round;
	}
	
	protected boolean isLastRound(){
		return actualIndex == size() - 1;
	}

}
