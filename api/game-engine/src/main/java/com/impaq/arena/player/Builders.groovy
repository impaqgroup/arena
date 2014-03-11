package com.impaq.arena.player;

import com.impaq.arena.engine.GameConfig;

class Builders extends Figures {

    final int productivity;

    Builders(GameConfig config) {
        this(config.buildersStartCount(), config.buildersStrength());
    }

    Builders(int startCount, int productivity) {
        super(startCount);
        this.productivity = productivity;
    }

    public int getProductivity() {
        return getCount() * productivity;
    }

}
