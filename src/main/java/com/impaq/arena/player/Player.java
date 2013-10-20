package com.impaq.arena.player;

import com.impaq.arena.engine.Property;
import com.impaq.arena.rounds.IRoundManager;

public class Player {

    private Castle castle;
    private Builders builders;
    private Wizards wizards;
    private Warriors warriors;
    private IRoundManager roundManager;

    public Player(IRoundManager roundManager) {
	this.roundManager = roundManager;
	this.setDefaults(new Property());
    }

    public Castle getCastle() {
	return castle;
    }

    public boolean isWinner() {
	return castle.isMax();
    }

    public boolean isLoser() {
	return castle.isMin();
    }

    public Builders getBuilders() {
	return builders;
    }

    public Wizards getWizards() {
	return wizards;
    }

    public Warriors getWarriors() {
	return warriors;
    }

    public IRoundManager getRoundManager() {
	return roundManager;
    }

    public void setDefaults(Property property) {
	builders = new Builders(Integer.valueOf(property
		.getProperty(PropertyNames.BUILDERS_START_COUNT)),
		Double.valueOf(property
			.getProperty(PropertyNames.BUILDERS_PRODUCTIVITY)));
	
	warriors = new Warriors(Integer.valueOf(property
		.getProperty(PropertyNames.WARRIORS_START_COUNT)),
		Double.valueOf(property
			.getProperty(PropertyNames.WARRIORS_STRENGTH)));
	
	wizards = new Wizards(Integer.valueOf(property
		.getProperty(PropertyNames.WIZARDS_START_COUNT)),
		Double.valueOf(property
			.getProperty(PropertyNames.WIZARDS_STRENGTH)));
	
	castle = new Castle(Integer.valueOf(property
		.getProperty(PropertyNames.CASTLE_MAX_HEIGHT)),
		Integer.valueOf(property
			.getProperty(PropertyNames.CASTLE_START_HEIGHT)));
    }
}
