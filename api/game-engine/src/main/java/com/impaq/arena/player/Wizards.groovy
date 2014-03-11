package com.impaq.arena.player;

import com.impaq.arena.engine.GameConfig;

class Wizards extends Figures {

    final int strength;

    Wizards(GameConfig config) {
        this(config.wizardsStartCount(), config.wizardsStrength());
    }

    Wizards(int startCount, int strength) {
        super(startCount);
        this.strength = strength;
    }

    int getStrength() {
        return this.getCount() * strength;
    }
}
