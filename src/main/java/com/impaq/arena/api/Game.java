package com.impaq.arena.api;

/**
 * Main game interface. Describes what you can do in the game.
 */
public interface Game {

    long myCastleHeight();

    long myWarriorsCount();

    int myWarriorsStrength();

    long myWizzardsCount();

    int myWizardsStrength();

    long myBuildersCount();

    int myBuildersProductivity();

    boolean canAct();

    boolean canBuild();

    void buildMyCastle();

    boolean canAttack();

    void attackEnemyCastle();

    void attackEnemyWizzards();

    void attackEnemyWarriors();

    void attackEnemyBuilders();

    boolean canRecruit();

    void recruitBuilders();

    void recruitWizzards();

    void recruitWarriors();

    boolean canSpy();

    long spyEnemyCastleHeight();

    long spyEnemyWarriorsCount();

    long spyEnemyWizzardsCount();

    long spyEnemyBuildersCount();
}
