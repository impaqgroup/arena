package com.impaq.arena

import com.google.common.eventbus.EventBus
import com.impaq.arena.engine.SimplePlayerStrategyExecutor
import com.impaq.arena.event.AttackBuilders
import com.impaq.arena.event.AttackCastle
import com.impaq.arena.event.AttackWarriors
import com.impaq.arena.event.AttackWizards
import com.impaq.arena.event.BuildCastle
import com.impaq.arena.event.RecruitBuilders
import com.impaq.arena.event.RecruitWarriors
import com.impaq.arena.event.RecruitWizards
import com.impaq.arena.event.SpyBuilders
import com.impaq.arena.event.SpyCastle
import com.impaq.arena.event.SpyWarriors
import com.impaq.arena.event.SpyWizards
import com.impaq.arena.player.Player

class EventDrivenPlayerStrategyExecutor extends SimplePlayerStrategyExecutor {

    private final EventBus eventBus

    EventDrivenPlayerStrategyExecutor(Player player, Player opponent, EventBus eventBus) {
        super(player, opponent)
        this.eventBus = eventBus
    }

    @Override
    protected void doAttackEnemyWizards() {
        super.doAttackEnemyWizards()
        dispatchEvent(new AttackWizards(player, myWizardsStrength()))
    }

    @Override
    protected void doAttackEnemyWarriors() {
        super.doAttackEnemyWarriors()
        dispatchEvent(new AttackWarriors(player, myWizardsStrength()))
    }

    @Override
    protected void doAttackEnemyBuilders() {
        super.doAttackEnemyBuilders()
        dispatchEvent(new AttackBuilders(player, myWizardsStrength()))
    }

    @Override
    protected void doAttackEnemyCastle() {
        super.doAttackEnemyCastle()
        dispatchEvent(new AttackCastle(player, myWarriorsStrength()))
    }

    @Override
    protected void doBuildMyCastle() {
        super.doBuildMyCastle()
        dispatchEvent(new BuildCastle(player, myBuildersProductivity()))
    }

    @Override
    protected void doRecruitBuilders() {
        super.doRecruitBuilders()
        dispatchEvent(new RecruitBuilders(player, 1))
    }

    @Override
    protected void doRecruitWizards() {
        super.doRecruitWizards()
        dispatchEvent(new RecruitWizards(player, 1))
    }

    @Override
    protected void doRecruitWarriors() {
        super.doRecruitWarriors()
        dispatchEvent(new RecruitWarriors(player, 2));
    }

    @Override
    protected int doSpyEnemyCastleHeight() {
        int height = super.doSpyEnemyCastleHeight()
        dispatchEvent(new SpyCastle(player))
        return height
    }

    @Override
    protected int doSpyEnemyWarriorsCount() {
        int count = super.doSpyEnemyWarriorsCount()
        dispatchEvent(new SpyWarriors(player))
        return count
    }

    @Override
    protected int doSpyEnemyWizardsCount() {
        int count = super.doSpyEnemyWizardsCount()
        dispatchEvent(new SpyWizards(player))
        return count
    }

    @Override
    protected int doSpyEnemyBuildersCount() {
        int count = super.doSpyEnemyBuildersCount()
        dispatchEvent(new SpyBuilders(player))
        return count
    }

    private void dispatchEvent(Object object) {
        eventBus.post(object);
    }
}
