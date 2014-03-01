package com.impaq.arena;

import com.google.common.eventbus.EventBus;
import com.impaq.arena.event.BuildCastle;
import com.impaq.arena.event.DestroyCastle;
import com.impaq.arena.event.KillBuilders;
import com.impaq.arena.event.KillWarriors;
import com.impaq.arena.event.AddBuilders;
import com.impaq.arena.event.AddWarriors;
import com.impaq.arena.event.AddWizards;
import com.impaq.arena.event.KillWizards;
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
        return (buildCount + attackCount + spyCount + recruitCount) < 3;
    }

    @Override
    public boolean canBuild() {
        return canAct() && (buildCount < 1);
    }

    @Override
    public boolean canAttack() {
        return canAct() && (attackCount < 1);
    }

    @Override
    public boolean canSpy() {
        return canAct() && (spyCount < 1);
    }

    @Override
    public boolean canRecruit() {
        return canAct() && (recruitCount < 1);
    }

    @Override
    public final void attackEnemyWizzards() {
        if (!canAttack()) {
            return;
        }

        dispatchEvent(new KillWizards(current, myWizardsStrength()));
        oponent.getWizards().kill(myWizardsStrength());
        attackCount++;
    }

    @Override
    public final void attackEnemyWarriors() {
        if (!canAttack()) {
            return;
        }
        oponent.getWarriors().kill(myWizardsStrength());
        dispatchEvent(new KillWarriors(current, myWizardsStrength()));
        attackCount++;
    }

    @Override
    public final void attackEnemyBuilders() {
        if (!canAttack()) {
            return;
        }

        oponent.getBuilders().kill(myWizardsStrength());
        dispatchEvent(new KillBuilders(current, myWizardsStrength()));
        attackCount++;
    }

    @Override
    public final void attackEnemyCastle() {
        if (!canAttack()) {
            return;
        }
        oponent.getCastle().destroy(myWarriorsStrength());
        dispatchEvent(new DestroyCastle(current, myWarriorsStrength()));
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
        dispatchEvent(new AddBuilders(current, 1));
        recruitCount++;
    }

    @Override
    public final void recruitWizzards() {
        if (!canRecruit()) {
            return;
        }
        current.getWizards().add(1);
        dispatchEvent(new AddWizards(current, 1));
        recruitCount++;
    }

    @Override
    public final void recruitWarriors() {
        if (!canRecruit()) {
            return;
        }
        current.getWarriors().add(2);
        dispatchEvent(new AddWarriors(current, 2));
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
    public final long spyEnemyWizzardsCount() {
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
    public final long myWizzardsCount() {
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
