package com.impaq.arena.engine

import com.impaq.arena.api.PlayerStrategy
import com.impaq.arena.player.Player
import spock.lang.Specification

class SimplePlayerStrategyExecutorTest extends Specification {

    PlayerStrategy playerStrategy = Mock(PlayerStrategy)
    PlayerStrategy opponentStrategy = Mock(PlayerStrategy)

    Player player = new Player("player", playerStrategy)
    Player opponent = new Player("opponent", opponentStrategy)

    SimplePlayerStrategyExecutor executor = new SimplePlayerStrategyExecutor(player, opponent)

    def "Should execute player strategy each round"() {
        when:
            executor.playRound()
        then:
            1 * player.getStrategy().playRound(executor)
    }

    def "Should be able to attack enemy wizards once per turn"() {
        when:
            boolean canAct = executor.canAct()
        then:
            canAct
            executor.canAttack()
            executor.attackEnemyWizards()

            executor.canAct()
            !executor.canAttack()
            !executor.attackEnemyWizards()
    }
}
