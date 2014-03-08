package com.impaq.arena.api;

/**
 * Main game interface. Describes what you can do in the game. To win you need to either build your castle
 * up to 100 stories, or level your opponent castle to the ground.
 */
public interface Game {

    // You can check your status with following methods as many times as you wish

    /**
     * You start at 25. Build it to 100 to win. Or level your opponents castle to the ground.
     */
    long myCastleHeight();

    /**
     * You start with 6 warriors. Use them to destroy opponents castle.
     */
    long myWarriorsCount();

    /**
     * Each warrior has strength of 1, so he can destroy one level of opponents castle per round.
     * This method will give you the total strength of all your warriors at given time.
     */
    int myWarriorsStrength();

    /**
     * You start with 3 wizards. Use them to kill opponents builders, warriors and wizards.
     */
    long myWizardsCount();

    /**
     * Each wizard has has strength of 2, so he can kill 2 builders, warriors or wizards per turn.
     * This method will give you the total strength of all your wizards at given time.
     */
    int myWizardsStrength();

    /**
     * You start with 2 builders.
     */
    long myBuildersCount();

    /**
     * Each builder can build 3 levels of your castle per turn.
     * This method will give you the total productivity of all your builders at given time.
     */
    int myBuildersProductivity();

    /**
     * You can act once per turn. You can either build your own castle, or attack your opponent.
     * This method will tell you if can still act this turn.
     */
    boolean canAct();

    /**
     * You can build your castle once per turn.
     * This method will tell you if you already did it this turn.
     */
    boolean canBuild();

    /**
     * You can attack your opponent once per turn.
     * This method will tell you if you already did it this turn.
     */
    boolean canAttack();

    /**
     * You can recruit new units twice per turn.
     * This method will tell you if you can still do it this turn.
     */
    boolean canRecruit();

    /**
     * You can spy on your opponent twice per turn.
     * This method will tell you if you can still do it this turn.
     */
    boolean canSpy();

    // You can act once per round, so from following methods can only one can be called and only once per round.

    /**
     * This will make your builders build new levels of your castle.
     * @see #myBuildersProductivity()
     */
    void buildMyCastle();

    /**
     * This will make your warriors destroy your opponents castle.
     * @see #myWarriorsStrength()
     */
    void attackEnemyCastle();

    /**
     * This will make your wizards attack enemy wizards.
     * @see #myWizardsStrength()
     */
    void attackEnemyWizards();

    /**
     * This will make your wizards attack enemy warriors.
     * @see #myWizardsStrength()
     */
    void attackEnemyWarriors();

    /**
     * This will make your wizards attack enemy builders.
     * @see #myWizardsStrength()
     */
    void attackEnemyBuilders();

    // You can recruit twice per round, so you can do no more than two calls to any of following methods.

    /**
     * This method will recruit one new builder.
     */
    void recruitBuilders();

    /**
     * This method will recruit one new wizard.
     */
    void recruitWizards();

    /**
     * This method will recruit two new warriors.
     */
    void recruitWarriors();

    // You can spy your opponent twice per round, so you can do no more than two calls to any of following methods.

    /**
     * This method will tel you how high your opponents castle is.
     */
    int spyEnemyCastleHeight();

    /**
     * This method will tell you how many warriors your opponent have.
     */
    int spyEnemyWarriorsCount();

    /**
     * This method will tell you how many wizards your opponent have.
     */
    int spyEnemyWizardsCount();

    /**
     * This method will tell you how many builders your opponent have.
     */
    int spyEnemyBuildersCount();
}
