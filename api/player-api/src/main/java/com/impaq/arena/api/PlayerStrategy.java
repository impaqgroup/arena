package com.impaq.arena.api;

/**
 * This is the interface you need to implement to play. Only one instance of the class you implement will be created
 * and will be reused in each round on the game.
 */
public interface PlayerStrategy {

    /**
     * This method will be called each round to execute your strategy.
     * @param game provides access to the current state of the game and available actions.
     */
    void playRound(Game game);

}
