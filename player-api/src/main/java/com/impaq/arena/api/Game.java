package com.impaq.arena.api;

/**
 * Main game interface. Describes what you can do in the game.
 */
public interface Game {

    long myCastleHeight();

    long myWarriorsCount();

    int myWarriorsStrength();

    long myWizardsCount();

    int myWizardsStrength();

    long myBuildersCount();

    int myBuildersProductivity();

    boolean canAct();

    boolean canBuild();

    void buildMyCastle();

    boolean canAttack();

    void attackEnemyCastle();

    void attackEnemyWizards();

    void attackEnemyWarriors();

    void attackEnemyBuilders();

    boolean canRecruit();

    void recruitBuilders();

    void recruitWizards();

    void recruitWarriors();

    boolean canSpy();

    long spyEnemyCastleHeight();

    long spyEnemyWarriorsCount();

    long spyEnemyWizardsCount();

    long spyEnemyBuildersCount();
}
