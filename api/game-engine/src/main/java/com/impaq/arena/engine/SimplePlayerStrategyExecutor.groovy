package com.impaq.arena.engine

import com.impaq.arena.api.Game
import com.impaq.arena.player.Player

public class SimplePlayerStrategyExecutor implements PlayerStrategyExecutor, Game {

    private final Player player
    private final Player opponent

    private int buildCount
    private int attackCount
    private int spyCount
    private int recruitCount

    public SimplePlayerStrategyExecutor(Player player, Player opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getOpponent() {
        return opponent;
    }

    public void playRound() {
        buildCount = 0;
        attackCount = 0;
        spyCount = 0;
        recruitCount = 0;
        player.getStrategy().playRound(this);
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
            attackCount++;
        }
        return false
    }

    @Override
    public boolean attackEnemyWarriors() {
        if (canAttack()) {
            opponent.getWarriors().kill(myWizardsStrength());
            attackCount++;
        }
        return false
    }

    @Override
    public boolean attackEnemyBuilders() {
        if (canAttack()) {
            opponent.getBuilders().kill(myWizardsStrength());
            attackCount++;
        }
        return false
    }

    @Override
    public boolean attackEnemyCastle() {
        if (canAttack()) {
            opponent.getCastle().destroy(myWarriorsStrength());
            attackCount++;
        }
        return false
    }

    @Override
    public boolean buildMyCastle() {
        if (canAct()) {
            player.getCastle().expand(myBuildersProductivity());
            buildCount++;
        }
        return false
    }

    @Override
    public boolean recruitBuilders() {
        if (canRecruit()) {
            player.getBuilders().add(1);
            recruitCount++;
        }
        return false
    }

    @Override
    public boolean recruitWizards() {
        if (canRecruit()) {
            player.getWizards().add(1);
            recruitCount++;
        }
        return false
    }

    @Override
    public boolean recruitWarriors() {
        if (canRecruit()) {
            player.getWarriors().add(2);
            recruitCount++;
        }
        return false
    }

    @Override
    public int spyEnemyCastleHeight() {
        if (canSpy()) {
            return doSpyEnemyCastleHeight()
        }
        return -1;
    }

    protected int doSpyEnemyCastleHeight() {
        spyCount++;
        return opponent.getCastle().spy();
    }

    @Override
    public int spyEnemyWarriorsCount() {
        if (canSpy()) {
            return doSpyEnemyWarriorsCount()
        }
        return -1;
    }

    protected int doSpyEnemyWarriorsCount() {
        spyCount++;
        return opponent.getWarriors().spy();
    }

    @Override
    public int spyEnemyWizardsCount() {
        if (canSpy()) {
            return doSpyEnemyWizardsCount()
        }
        return -1;
    }

    protected int doSpyEnemyWizardsCount() {
        spyCount++;
        return opponent.getWizards().spy();
    }

    @Override
    public int spyEnemyBuildersCount() {
        if (canSpy()) {
            return doSpyEnemyBuildersCount()
        }
        return -1;
    }

    protected int doSpyEnemyBuildersCount() {
        spyCount++;
        return opponent.getBuilders().spy();
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
