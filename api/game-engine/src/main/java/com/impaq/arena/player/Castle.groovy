package com.impaq.arena.player;

import com.impaq.arena.engine.GameConfig;

class Castle {

    int height;
    final int maxHeight;

    Castle(GameConfig config) {
        this(config.castleStartHeight(), config.castleMaxHeight());
    }

    Castle(int startHeight, int maxHeight) {
        this.maxHeight = maxHeight;
        this.height = startHeight;
    }

    int getHeight() {
        return height;
    }

    void expand(int height) {
        this.height += height;
    }

    void destroy(int height) {
        this.height -= height;
    }

    boolean isMax() {
        return height >= maxHeight;
    }

    boolean isMin() {
        return height <= 0;
    }

    int spy() {
        return getHeight();
    }
}
