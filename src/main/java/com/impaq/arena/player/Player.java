package com.impaq.arena.player;

import com.impaq.arena.PropertySource;
import com.impaq.arena.Strategy;

public class Player {

    private final Castle castle;
    private final Builders builders;
    private final Wizards wizards;
    private final Warriors warriors;
    private final Strategy strategy;

    public Player(Strategy roundManager, Castle castle, Builders builders, Wizards wizards, Warriors warriors) {
        this.strategy = roundManager;
        this.castle = castle;
        this.builders = builders;
        this.wizards = wizards;
        this.warriors = warriors;
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

    public Strategy getRoundManager() {
        return strategy;
    }
}
