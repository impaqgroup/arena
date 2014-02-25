package com.impaq.arena;

import java.util.ArrayList;

public class Strategy extends ArrayList<RoundStrategy> {

    private int actualIndex = -1;

    public RoundStrategy next() {
        return get(actualIndex = ((actualIndex + 1) % size()));
    }

}
