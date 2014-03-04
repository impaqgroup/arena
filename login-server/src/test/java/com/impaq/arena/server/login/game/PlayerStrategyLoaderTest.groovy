package com.impaq.arena.server.login.game

import com.impaq.arena.api.Game
import com.impaq.arena.api.PlayerStrategy
import com.impaq.arena.server.login.player.strategy.PlayerStrategyService
import org.springframework.core.io.DefaultResourceLoader
import org.springframework.core.io.ResourceLoader
import spock.lang.Specification

class PlayerStrategyLoaderTest extends Specification {

    ResourceLoader resourceLoader = new DefaultResourceLoader()

    PlayerStrategyService strategyService = Mock(PlayerStrategyService)

    Game game = Mock(Game)

    def "Should compile and run strategy from source"() {
        given:
            PlayerStrategyLoader strategyLoader = new PlayerStrategyLoader(resourceLoader, strategyService)
            InputStream strategyCode = resourceLoader.getResource("classpath:ExampleStrategy.java").getInputStream()
        when:
            PlayerStrategy strategy = strategyLoader.loadStrategy("ExampleStrategy", strategyCode.getText())
            strategy.playRound(game)
        then:
            1 * game.spyEnemyWizardsCount()

    }
}
