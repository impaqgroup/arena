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
    public final void attackEnemyWizards() {
        if (canAttack()) {
            doAttackEnemyWizards()
        }
    }

    protected void doAttackEnemyWizards() {
        opponent.getWizards().kill(myWizardsStrength());
        attackCount++;
    }

    @Override
    public final void attackEnemyWarriors() {
        if (canAttack()) {
            doAttackEnemyWarriors()
        }
    }

    protected void doAttackEnemyWarriors() {
        opponent.getWarriors().kill(myWizardsStrength());
        attackCount++;
    }

    @Override
    public final void attackEnemyBuilders() {
        if (canAttack()) {
            doAttackEnemyBuilders()
        }
    }

    protected void doAttackEnemyBuilders() {
        opponent.getBuilders().kill(myWizardsStrength());
        attackCount++;
    }

    @Override
    public final void attackEnemyCastle() {
        if (canAttack()) {
            doAttackEnemyCastle()
        }
    }

    protected void doAttackEnemyCastle() {
        opponent.getCastle().destroy(myWarriorsStrength());
        attackCount++;
    }

    @Override
    public final void buildMyCastle() {
        if (canAct()) {
            doBuildMyCastle()
        }
    }

    protected void doBuildMyCastle() {
        player.getCastle().expand(myBuildersProductivity());
        buildCount++;
    }

    @Override
    public final void recruitBuilders() {
        if (canRecruit()) {
            doRecruitBuilders()
        }
    }

    protected void doRecruitBuilders() {
        player.getBuilders().add(1);
        recruitCount++;
    }

    @Override
    public final void recruitWizards() {
        if (canRecruit()) {
            doRecruitWizards()
        }
    }

    protected void doRecruitWizards() {
        player.getWizards().add(1);
        recruitCount++;
    }

    @Override
    public final void recruitWarriors() {
        if (canRecruit()) {
            doRecruitWarriors()
        }
    }

    protected void doRecruitWarriors() {
        player.getWarriors().add(2);
        recruitCount++;
    }

    @Override
    public final int spyEnemyCastleHeight() {
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
    public final int spyEnemyWarriorsCount() {
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
    public final int spyEnemyWizardsCount() {
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
    public final int spyEnemyBuildersCount() {
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
    public final long myCastleHeight() {
        return player.getCastle().getHeight();
    }

    @Override
    public final long myWarriorsCount() {
        return player.getWarriors().getCount();
    }

    @Override
    public final long myWizardsCount() {
        return player.getWizards().getCount();
    }

    @Override
    public final long myBuildersCount() {
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
