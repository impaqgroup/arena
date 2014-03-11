package com.impaq.arena.server.engine

import com.google.common.eventbus.EventBus
import com.impaq.arena.engine.SimpleGameRound
import com.impaq.arena.player.Player
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
import groovy.transform.TypeChecked

@TypeChecked
class EventDrivenGameRound extends SimpleGameRound {

    private final EventBus eventBus

    EventDrivenGameRound(Player player, Player opponent, EventBus eventBus) {
        super(player, opponent)
        this.eventBus = eventBus
    }

    @Override
    boolean buildMyCastle() {
        if (super.buildMyCastle()) {
            return dispatchEvent(new BuildCastle(player, myBuildersProductivity()))
        }
        return false
    }

    @Override
    boolean attackEnemyCastle() {
        if (super.attackEnemyCastle()) {
            return dispatchEvent(new AttackCastle(player, myWarriorsStrength()))
        }
        return false
    }

    @Override
    boolean attackEnemyWizards() {
        if (super.attackEnemyWizards()) {
            return dispatchEvent(new AttackWizards(player, myWizardsStrength()))
        }
        return false
    }

    @Override
    boolean attackEnemyWarriors() {
        if (super.attackEnemyWarriors()) {
            return dispatchEvent(new AttackWarriors(player, myWizardsStrength()))
        }
        return false
    }

    @Override
    boolean attackEnemyBuilders() {
        if (super.attackEnemyBuilders()) {
            return dispatchEvent(new AttackBuilders(player, myWizardsStrength()))
        }
        return false
    }

    @Override
    boolean recruitBuilders() {
        if (super.recruitBuilders()) {
            return dispatchEvent(new RecruitBuilders(player, 1))
        }
        return false
    }

    @Override
    boolean recruitWizards() {
        if (super.recruitWizards()) {
            return dispatchEvent(new RecruitWizards(player, 1))
        }
        return false
    }

    @Override
    boolean recruitWarriors() {
        if (super.recruitWarriors()) {
            return dispatchEvent(new RecruitWarriors(player, 2));
        }
        return false
    }

    @Override
    int spyEnemyCastleHeight() {
        int height = super.spyEnemyCastleHeight()
        if (height >= 0) {
            dispatchEvent(new SpyCastle(player))
        }
        return height
    }

    @Override
    int spyEnemyWarriorsCount() {
        int count = super.spyEnemyWarriorsCount()
        if (count >= 0) {
            dispatchEvent(new SpyWarriors(player))
        }
        return count
    }

    @Override
    int spyEnemyWizardsCount() {
        int count = super.spyEnemyWizardsCount()
        if (count >= 0) {
            dispatchEvent(new SpyWizards(player))
        }
        return count
    }

    @Override
    int spyEnemyBuildersCount() {
        int count = super.spyEnemyWarriorsCount()
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