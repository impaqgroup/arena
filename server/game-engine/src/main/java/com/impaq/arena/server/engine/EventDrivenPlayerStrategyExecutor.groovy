package com.impaq.arena.server.engine

import com.google.common.eventbus.EventBus
import com.impaq.arena.api.Game
import com.impaq.arena.engine.PlayerStrategyExecutor
import com.impaq.arena.engine.SimplePlayerStrategyExecutor
import com.impaq.arena.server.event.AttackBuilders
import com.impaq.arena.server.event.AttackCastle
import com.impaq.arena.server.event.AttackWarriors
import com.impaq.arena.server.event.AttackWizards
import com.impaq.arena.server.event.BuildCastle
import com.impaq.arena.server.event.RecruitBuilders
import com.impaq.arena.server.event.RecruitWarriors
import com.impaq.arena.server.event.RecruitWizards
import com.impaq.arena.server.event.SpyBuilders
import com.impaq.arena.server.event.SpyCastle
import com.impaq.arena.server.event.SpyWarriors
import com.impaq.arena.server.event.SpyWizards
import com.impaq.arena.player.Player
import groovy.transform.TypeChecked

@TypeChecked
class EventDrivenPlayerStrategyExecutor implements PlayerStrategyExecutor, Game {

    private final SimplePlayerStrategyExecutor delegate
    private final EventBus eventBus

    EventDrivenPlayerStrategyExecutor(Player player, Player opponent, EventBus eventBus) {
        this.delegate = new SimplePlayerStrategyExecutor(player, opponent)
        this.eventBus = eventBus
    }

    @Override
    Player getPlayer() {
        return delegate.player
    }

    @Override
    Player getOpponent() {
        return delegate.opponent
    }

    @Override
    void playRound() {
        delegate.playRound()
    }

    @Override
    long myCastleHeight() {
        return delegate.myCastleHeight()
    }

    @Override
    long myWarriorsCount() {
        return delegate.myWarriorsCount()
    }

    @Override
    int myWarriorsStrength() {
        return delegate.myWarriorsStrength()
    }

    @Override
    long myWizardsCount() {
        return delegate.myWizardsCount()
    }

    @Override
    int myWizardsStrength() {
        return delegate.myWizardsStrength()
    }

    @Override
    long myBuildersCount() {
        return delegate.myBuildersCount()
    }

    @Override
    int myBuildersProductivity() {
        return delegate.myBuildersProductivity()
    }

    @Override
    boolean canAct() {
        return delegate.canAct()
    }

    @Override
    boolean canBuild() {
        return delegate.canBuild()
    }

    @Override
    boolean canAttack() {
        return delegate.canAttack()
    }

    @Override
    boolean canRecruit() {
        return delegate.canRecruit()
    }

    @Override
    boolean canSpy() {
        return delegate.canSpy()
    }

    @Override
    boolean buildMyCastle() {
        if (delegate.buildMyCastle()) {
            return dispatchEvent(new BuildCastle(player, myBuildersProductivity()))
        }
        return false
    }

    @Override
    boolean attackEnemyCastle() {
        if (delegate.attackEnemyCastle()) {
            return dispatchEvent(new AttackCastle(player, myWarriorsStrength()))
        }
        return false
    }

    @Override
    boolean attackEnemyWizards() {
        if (delegate.attackEnemyWizards()) {
            return dispatchEvent(new AttackWizards(player, myWizardsStrength()))
        }
        return false
    }

    @Override
    boolean attackEnemyWarriors() {
        if (delegate.attackEnemyWarriors()) {
            return dispatchEvent(new AttackWarriors(player, myWizardsStrength()))
        }
        return false
    }

    @Override
    boolean attackEnemyBuilders() {
        if (delegate.attackEnemyBuilders()) {
            return dispatchEvent(new AttackBuilders(player, myWizardsStrength()))
        }
        return false
    }

    @Override
    boolean recruitBuilders() {
        if (delegate.recruitBuilders()) {
            return dispatchEvent(new RecruitBuilders(player, 1))
        }
        return false
    }

    @Override
    boolean recruitWizards() {
        if (delegate.recruitWizards()) {
            return dispatchEvent(new RecruitWizards(player, 1))
        }
        return false
    }

    @Override
    boolean recruitWarriors() {
        if (delegate.recruitWarriors()) {
            return dispatchEvent(new RecruitWarriors(player, 2));
        }
        return false
    }

    @Override
    int spyEnemyCastleHeight() {
        int height = delegate.spyEnemyCastleHeight()
        if (height >= 0) {
            dispatchEvent(new SpyCastle(player))
        }
        return height
    }

    @Override
    int spyEnemyWarriorsCount() {
        int count = delegate.spyEnemyWarriorsCount()
        if (count >= 0) {
            dispatchEvent(new SpyWarriors(player))
        }
        return count
    }

    @Override
    int spyEnemyWizardsCount() {
        int count = delegate.spyEnemyWizardsCount()
        if (count >= 0) {
            dispatchEvent(new SpyWizards(player))
        }
        return count
    }

    @Override
    int spyEnemyBuildersCount() {
        int count = delegate.spyEnemyWarriorsCount()
        if (count >= 0) {
            dispatchEvent(new SpyBuilders(player))
        }
        return count
    }

    private boolean dispatchEvent(Object object) {
        eventBus.post(object);
        return true
    }

}
