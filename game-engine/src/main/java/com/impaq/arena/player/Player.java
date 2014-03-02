package com.impaq.arena.player;

import com.impaq.arena.api.PlayerStrategy;

public class Player {

    private final String id;
    private final Castle castle;
    private final Builders builders;
    private final Wizards wizards;
    private final Warriors warriors;
    private final PlayerStrategy strategy;

    public Player(String id, PlayerStrategy strategy) {
        this(id, strategy, new Castle(30, 100), new Builders(2, 3), new Wizards(3, 2), new Warriors(6, 1));
    }

    public Player(String id, PlayerStrategy strategy, Castle castle, Builders builders, Wizards wizards, Warriors warriors) {
        this.id = id;
        this.strategy = strategy;
        this.castle = castle;
        this.builders = builders;
        this.wizards = wizards;
        this.warriors = warriors;
    }

    public String getId() {
        return id;
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
