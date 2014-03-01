package com.impaq.arena.player;

import com.impaq.arena.api.PlayerStrategy;

public class Player {

    private final Castle castle;
    private final Builders builders;
    private final Wizards wizards;
    private final Warriors warriors;
    private final PlayerStrategy strategy;

    public Player(PlayerStrategy strategy, Castle castle, Builders builders, Wizards wizards, Warriors warriors) {
        this.strategy = strategy;
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

    public PlayerStrategy getStrategy() {
        return strategy;
    }
}
