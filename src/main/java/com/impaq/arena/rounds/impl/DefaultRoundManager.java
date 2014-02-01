package com.impaq.arena.rounds.impl;

import java.util.ArrayList;

import com.impaq.arena.RoundStrategy;
import com.impaq.arena.Strategy;

public class DefaultRoundManager extends ArrayList<RoundStrategy> implements Strategy {

    private int actualIndex = -1;

    @Override
    public RoundStrategy next() {
        return get(actualIndex = ((actualIndex+1)% size()));
    }

}
