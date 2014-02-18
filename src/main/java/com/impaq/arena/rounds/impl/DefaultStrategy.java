package com.impaq.arena.rounds.impl;

import com.impaq.arena.RoundStrategy;
import com.impaq.arena.Strategy;
import java.util.ArrayList;

public class DefaultStrategy extends ArrayList<RoundStrategy> implements Strategy {

    private int actualIndex = -1;

    @Override
    public RoundStrategy next() {
        return get(actualIndex = ((actualIndex+1)% size()));
    }

}
