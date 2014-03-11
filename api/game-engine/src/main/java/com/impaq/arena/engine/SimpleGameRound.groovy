package com.impaq.arena.engine

import com.impaq.arena.api.Game
import com.impaq.arena.player.Player

class SimpleGameRound implements Game {

    protected final Player player
    protected final Player opponent

    private int buildCount
    private int attackCount
    private int spyCount
    private int recruitCount

    SimpleGameRound(Player player, Player opponent) {
        this.player = player
        this.opponent = opponent
    }

    @Override
    public boolean canAct() {
        return (buildCount + attackCount + spyCount + recruitCount) < 5;
    }

    @Override
    public boolean canBuild() {
        return canAct() && (buildCount + attackCount < 1);
    }

    @Override
    public boolean canAttack() {
        return canAct() && (buildCount + attackCount < 1);
    }

    @Override
    public boolean canSpy() {
        return canAct() && (spyCount < 2);
    }

    @Override
    public boolean canRecruit() {
        return canAct() && (recruitCount < 2);
    }

    @Override
    public boolean attackEnemyWizards() {
        if (canAttack()) {
            opponent.getWizards().kill(myWizardsStrength());
            return ++attackCount;
        }
        return false
    }

    @Override
    public boolean attackEnemyWarriors() {
        if (canAttack()) {
            opponent.getWarriors().kill(myWizardsStrength());
            return ++attackCount;
        }
        return false
    }

    @Override
    public boolean attackEnemyBuilders() {
        if (canAttack()) {
            opponent.getBuilders().kill(myWizardsStrength());
            return ++attackCount;
        }
        return false
    }

    @Override
    public boolean attackEnemyCastle() {
        if (canAttack()) {
            opponent.getCastle().destroy(myWarriorsStrength());
            return ++attackCount;
        }
        return false
    }

    @Override
    public boolean buildMyCastle() {
        if (canAct()) {
            player.getCastle().expand(myBuildersProductivity());
            return ++buildCount;
        }
        return false
    }

    @Override
    public boolean recruitBuilders() {
        if (canRecruit()) {
            player.getBuilders().add(1);
            return ++recruitCount;
        }
        return false
    }

    @Override
    public boolean recruitWizards() {
        if (canRecruit()) {
            player.getWizards().add(1);
            return ++recruitCount;
        }
        return false
    }

    @Override
    public boolean recruitWarriors() {
        if (canRecruit()) {
            player.getWarriors().add(2);
            return ++recruitCount;
        }
        return false
    }

    @Override
    public int spyEnemyCastleHeight() {
        if (canSpy()) {
            spyCount++;
            return opponent.getCastle().spy();
        }
        return -1;
    }

    @Override
    public int spyEnemyWarriorsCount() {
        if (canSpy()) {
            spyCount++;
            return opponent.getWarriors().spy();
        }
        return -1;
    }

    @Override
    public int spyEnemyWizardsCount() {
        if (canSpy()) {
            spyCount++;
            return opponent.getWizards().spy();
        }
        return -1;
    }

    @Override
    public int spyEnemyBuildersCount() {
        if (canSpy()) {
            spyCount++;
            return opponent.getBuilders().spy();
        }
        return -1;
    }

    @Override
    public long myCastleHeight() {
        return player.getCastle().getHeight();
    }

    @Override
    public long myWarriorsCount() {
        return player.getWarriors().getCount();
    }

    @Override
    public long myWizardsCount() {
        return player.getWizards().getCount();
    }

    @Override
    public long myBuildersCount() {
        return player.getBuilders().getCount();
    }

    @Override
    public int myWizardsStrength() {
        return player.getWizards().getStrength();
    }

    @Override
    public int myWarriorsStrength() {
        return player.getWarriors().getStrength();
    }

    @Override
    public int myBuildersProductivity() {
        return player.getBuilders().getProductivity();
    }
}
