package com.impaq.arena.server.engine

import com.impaq.arena.engine.DefaultGameConfig;
import org.springframework.core.env.Environment;

class EnvironmentBasedGameConfig extends DefaultGameConfig {

    private final Environment environment;

    EnvironmentBasedGameConfig(Environment environment) {
        this.environment = environment;
    }

    @Override
    int buildersStartCount() {
        return environment.getProperty("builders.start.count", Integer, super.buildersStartCount())
    }

    @Override
    int warriorsStartCount() {
        return environment.getProperty("warriors.start.count", Integer, super.warriorsStartCount())
    }

    @Override
    int wizardsStartCount() {
        return environment.getProperty("wizards.start.count", Integer, super.wizardsStartCount())
    }

    @Override
    int buildersStrength() {
        return environment.getProperty("builders.strength", Integer, super.buildersStrength())
    }

    @Override
    int wizardsStrength() {
        return environment.getProperty("wizards.strength", Integer, super.wizardsStrength())
    }

    @Override
    int warriorsStrength() {
        return environment.getProperty("warriors.strength", Integer, super.warriorsStrength())
    }

    @Override
    int castleStartHeight() {
        return environment.getProperty("castle.start.height", Integer, super.castleStartHeight())
    }

    @Override
    int castleMaxHeight() {
        return environment.getProperty("castle.max.height", Integer, super.castleMaxHeight())
    }

    @Override
    int maxRoundNumber() {
        return environment.getProperty("max.round.number", Integer, super.maxRoundNumber())
    }
}
