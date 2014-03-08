package com.impaq.arena.engine;

class DefaultGameConfig implements GameConfig {

    @Override
    int buildersStartCount() {
        return 2
    }

    @Override
    int warriorsStartCount() {
        return 6
    }

    @Override
    int wizardsStartCount() {
        return 3
    }

    @Override
    int buildersStrength() {
        return 3
    }

    @Override
    int wizardsStrength() {
        return 2
    }

    @Override
    int warriorsStrength() {
        return 1
    }

    @Override
    int castleStartHeight() {
        return 30
    }

    @Override
    int castleMaxHeight() {
        return 100
    }

    @Override
    int maxRoundNumber() {
        return 50
    }
}
