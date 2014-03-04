package com.impaq.arena;

import com.google.common.eventbus.EventBus;
import com.impaq.arena.event.BuildCastle;
import com.impaq.arena.event.AttackCastle;
import com.impaq.arena.event.AttackBuilders;
import com.impaq.arena.event.AttackWarriors;
import com.impaq.arena.event.RecruitBuilders;
import com.impaq.arena.event.RecruitWarriors;
import com.impaq.arena.event.RecruitWizards;
import com.impaq.arena.event.AttackWizards;
import com.impaq.arena.event.SpyBuilders;
import com.impaq.arena.event.SpyCastle;
import com.impaq.arena.event.SpyWarriors;
import com.impaq.arena.event.SpyWizards;
import com.impaq.arena.api.Game;
import com.impaq.arena.player.Player;
/**
 * Rules:<br>
 * Offensive (1 per round):
 * <ul>
 * <li>warrior destroy 1 level.</li>
 * <li>wizard kills 2 people.</li>
 * <li>builder builds 3 castle level.</li>
 * </ul>
 * <br>
 * Populate (2 per round)
 * in single add action you can add:
 * <ul>
 * <li>1 builder.</li>
 * <li>1 wizard.</li>
 * <li>2 warriors.</li>
 * </ul>
 * <br>
 * Spy (2 per round)
 */
public class RoundExecutor implements Game {

    private final Player current;
    private final Player oponent;
    private final EventBus eventBus;
    private int buildCount = 0;
    private int attackCount = 0;
    private int spyCount = 0;
    private int recruitCount = 0;

    public RoundExecutor(Player current, Player oponent, EventBus eventBus) {
        this.current = current;
        this.oponent = oponent;
        this.eventBus = eventBus;
    }

    public void playRound() {
        buildCount = 0;
        attackCount = 0;
        spyCount = 0;
        recruitCount = 0;
        current.getStrategy().playRound(this);
    }

    private void dispatchEvent(Object object) {
        eventBus.post(object);
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
        if (!canAttack()) {
            return;
        }
        oponent.getWizards().kill(myWizardsStrength());
        dispatchEvent(new AttackWizards(current, myWizardsStrength()));
        attackCount++;
    }

    @Override
    public final void attackEnemyWarriors() {
        if (!canAttack()) {
            return;
        }
        oponent.getWarriors().kill(myWizardsStrength());
        dispatchEvent(new AttackWarriors(current, myWizardsStrength()));
        attackCount++;
    }

    @Override
    public final void attackEnemyBuilders() {
        if (!canAttack()) {
            return;
        }

        oponent.getBuilders().kill(myWizardsStrength());
        dispatchEvent(new AttackBuilders(current, myWizardsStrength()));
        attackCount++;
    }

    @Override
    public final void attackEnemyCastle() {
        if (!canAttack()) {
            return;
        }
        oponent.getCastle().destroy(myWarriorsStrength());
        dispatchEvent(new AttackCastle(current, myWarriorsStrength()));
        attackCount++;
    }

    @Override
    public final void buildMyCastle() {
        if (!canAct()) {
            return;
        }
        current.getCastle().expand(myBuildersProductivity());
        dispatchEvent(new BuildCastle(current, myBuildersProductivity()));
        buildCount++;
    }

    @Override
    public final void recruitBuilders() {
        if (!canRecruit()) {
            return;
        }
        current.getBuilders().add(1);
        dispatchEvent(new RecruitBuilders(current, 1));
        recruitCount++;
    }

    @Override
    public final void recruitWizards() {
        if (!canRecruit()) {
            return;
        }
        current.getWizards().add(1);
        dispatchEvent(new RecruitWizards(current, 1));
        recruitCount++;
    }

    @Override
    public final void recruitWarriors() {
        if (!canRecruit()) {
            return;
        }
        current.getWarriors().add(2);
        dispatchEvent(new RecruitWarriors(current, 2));
        recruitCount++;
    }

    @Override
    public final long spyEnemyCastleHeight() {
        if (!canSpy()) {
            return -1;
        }
        dispatchEvent(new SpyCastle(current));
        spyCount++;
        return oponent.getCastle().spy();
    }

    @Override
    public final long spyEnemyWarriorsCount() {
        if (!canSpy()) {
            return -1;
        }
        dispatchEvent(new SpyWarriors(current));
        spyCount++;
        return oponent.getWarriors().spy();
    }

    @Override
    public final long spyEnemyWizardsCount() {
        if (!canSpy()) {
            return -1;
        }
        dispatchEvent(new SpyWizards(current));

        spyCount++;
        return oponent.getWizards().spy();
    }

    @Override
    public final long spyEnemyBuildersCount() {
        if (!canSpy()) {
            return -1;
        }
        dispatchEvent(new SpyBuilders(current));
        spyCount++;
        return oponent.getBuilders().spy();
    }

    @Override
    public final long myCastleHeight() {
        return current.getCastle().getHeight();
    }

    @Override
    public final long myWarriorsCount() {
        return current.getWarriors().getCount();
    }

    @Override
    public final long myWizardsCount() {
        return current.getWizards().getCount();
    }

    @Override
    public final long myBuildersCount() {
        return current.getBuilders().getCount();
    }

    @Override
    public int myWizardsStrength() {
        return current.getWizards().getStrength();
    }

    @Override
    public int myWarriorsStrength() {
        return current.getWarriors().getStrength();
    }

    @Override
    public int myBuildersProductivity() {
        return current.getBuilders().getProductivity();
    }
}
