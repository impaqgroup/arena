package com.impaq.arena;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ForwardingList;
/**
 * Rules:<br>
 * Offensive (1 per round):
 * <ul>
 * <li>warrior destroy 1 level.</li>
 * <li>wizard kills 2 people.</li>
 * <li>builder builds 3 castle level.</li>
 * </ul>
 * <br>
 * Populate (2 per round)
 * in single add action you can add:
 * <ul>
 * <li>1 builder.</li>
 * <li>1 wizard.</li>
 * <li>2 warriors.</li>
 * </ul>
 * <br>
 * Spy (2 per round)
 */
public class Strategy extends ForwardingList<RoundStrategy> {

	private int actualIndex = -1;

	private List<RoundStrategy> strategies = new ArrayList<>();

	public RoundStrategy next() {
		return get(actualIndex = ((actualIndex + 1) % size()));
	}

	@Override
	protected List<RoundStrategy> delegate() {
		return strategies;
	}

}
