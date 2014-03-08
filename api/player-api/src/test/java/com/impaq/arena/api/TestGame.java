package com.impaq.arena.api;

public class TestGame implements Game {

    @Override
    public long myCastleHeight() {
        return 0;
    }

    @Override
    public long myWarriorsCount() {
        return 0;
    }

    @Override
    public int myWarriorsStrength() {
        return 0;
    }

    @Override
    public long myWizardsCount() {
        return 0;
    }

    @Override
    public int myWizardsStrength() {
        return 0;
    }

    @Override
    public long myBuildersCount() {
        return 0;
    }

    @Override
    public int myBuildersProductivity() {
        return 0;
    }

    @Override
    public boolean canAct() {
        return false;
    }

    @Override
    public boolean canBuild() {
        return false;
    }

    @Override
    public boolean canAttack() {
        return false;
    }

    @Override
    public boolean canRecruit() {
        return false;
    }

    @Override
    public boolean canSpy() {
        return false;
    }

    @Override
    public void buildMyCastle() {

    }

    @Override
    public void attackEnemyCastle() {

    }

    @Override
    public void attackEnemyWizards() {

    }

    @Override
    public void attackEnemyWarriors() {

    }

    @Override
    public void attackEnemyBuilders() {

    }

    @Override
    public void recruitBuilders() {

    }

    @Override
    public void recruitWizards() {

    }

    @Override
    public void recruitWarriors() {

    }

    @Override
    public int spyEnemyCastleHeight() {
        return 0;
    }

    @Override
    public int spyEnemyWarriorsCount() {
        return 0;
    }

    @Override
    public int spyEnemyWizardsCount() {
        return 0;
    }

    @Override
    public int spyEnemyBuildersCount() {
        return 0;
    }
}
