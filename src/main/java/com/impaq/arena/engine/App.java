package com.impaq.arena.engine;

import com.impaq.arena.rounds.impl.EmptyRoundManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new Engine(new EmptyRoundManager(), new EmptyRoundManager()).startGame();
    }
}
