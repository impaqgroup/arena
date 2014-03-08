package com.impaq.arena.player;

import com.impaq.arena.engine.GameConfig;
import com.impaq.arena.api.PlayerStrategy;

class Player {

    final String id;
    final PlayerStrategy strategy;

    final Castle castle;
    final Builders builders;
    final Wizards wizards;
    final Warriors warriors;

    Player(String id, PlayerStrategy strategy) {
        this(id, strategy, new Castle(30, 100), new Builders(2, 3), new Wizards(3, 2), new Warriors(6, 1));
    }

    Player(String id, PlayerStrategy strategy, GameConfig config) {
        this(id, strategy, new Castle(config), new Builders(config), new Wizards(config), new Warriors(config));
    }

    Player(String id, PlayerStrategy strategy, Castle castle, Builders builders, Wizards wizards, Warriors warriors) {
        this.id = id;
        this.strategy = strategy;
        this.castle = castle;
        this.builders = builders;
        this.wizards = wizards;
        this.warriors = warriors;
    }

    boolean isWinner() {
        return castle.isMax();
    }

    boolean isLoser() {
        return castle.isMin();
    }
}
