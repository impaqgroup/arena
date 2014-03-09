package com.impaq.arena.engine

import com.impaq.arena.api.PlayerStrategy
import com.impaq.arena.player.Player
import spock.lang.Specification

class SimpleGameRoundTest extends Specification {

    PlayerStrategy playerStrategy = Mock(PlayerStrategy)
    PlayerStrategy opponentStrategy = Mock(PlayerStrategy)

    Player player = new Player("player", playerStrategy)
    Player opponent = new Player("opponent", opponentStrategy)

    SimpleGameRound round = new SimpleGameRound(player, opponent)

    def "Should be able to attack enemy wizards once per turn"() {
        when:
            boolean canAct = round.canAct()
        then:
            canAct
            round.canAttack()
            round.attackEnemyWizards()

            round.canAct()
            !round.canAttack()
            !round.attackEnemyWizards()
    }
}
