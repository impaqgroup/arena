package com.impaq.arena.player;

import com.impaq.arena.engine.GameConfig;

class Warriors extends Figures {

    final int strength;

    Warriors(GameConfig config) {
        this(config.warriorsStartCount(), config.warriorsStrength());
    }

    Warriors(int startCount, int strength) {
        super(startCount);
        this.strength = strength;
    }

    int getStrength() {
        return this.getCount() * strength;
    }

}
