package com.impaq.arena.server.engine

import com.google.common.eventbus.EventBus
import com.impaq.arena.api.PlayerStrategy
import com.impaq.arena.player.Player
import com.impaq.arena.server.event.BuildCastle
import spock.lang.Specification

class EventDrivenPlayerStrategyExecutorTest extends Specification {

    PlayerStrategy playerStrategy = Mock(PlayerStrategy)
    PlayerStrategy opponentStrategy = Mock(PlayerStrategy)

    Player player = new Player("player", playerStrategy)
    Player opponent = new Player("opponent", opponentStrategy)

    EventBus eventBus = Mock(EventBus)

    EventDrivenPlayerStrategyExecutor executor = new EventDrivenPlayerStrategyExecutor(player, opponent, eventBus)

    def "Should notify when player builds his castle"() {
        when:
            executor.buildMyCastle()
        then:
            1 * eventBus.post({it.player == player && it.value == 6} as BuildCastle)
    }

}
