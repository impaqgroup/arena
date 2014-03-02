package com.impaq.arena.server.login.game

import com.impaq.arena.server.login.game.log.GameLog
import com.impaq.arena.server.login.game.log.GameLogService
import com.impaq.arena.server.login.player.strategy.PlayerStrategy
import org.springframework.core.io.DefaultResourceLoader
import org.springframework.core.io.ResourceLoader
import spock.lang.Ignore
import spock.lang.Specification

class GameJobTest extends Specification {

    ResourceLoader resourceLoader = new DefaultResourceLoader()
    PlayerStrategyLoader strategyLoader = new PlayerStrategyLoader(resourceLoader)
    GameLogService gameLogService = Mock(GameLogService.class)

    String activeStrategyCode = resourceLoader.getResource("ExampleStrategy.java").getInputStream().getText()
    String idleStrategyCode = resourceLoader.getResource("ExampleStrategy_idle.java").getInputStream().getText()

    PlayerStrategy playerOneStrategy = new PlayerStrategy(
        playerId: "playerOne", className: "ExampleStrategy")
    PlayerStrategy playerTwoStrategy = new PlayerStrategy(
        playerId: "playerTwo", className: "ExampleStrategy")

    def "Should run game in which player one is a winner"() {
        given:
            playerOneStrategy.javaCode = activeStrategyCode
            playerTwoStrategy.javaCode = idleStrategyCode
            GameJob gameJob = new GameJob(playerOneStrategy, playerTwoStrategy, strategyLoader, gameLogService)
        when:
            gameJob.run()
        then:
            1 * gameLogService.save({GameLog log -> log.winner == "playerOne"})
    }

    def "Should run game in which player two is a winner"() {
        given:
            playerOneStrategy.javaCode = idleStrategyCode
            playerTwoStrategy.javaCode = activeStrategyCode
            GameJob gameJob = new GameJob(playerOneStrategy, playerTwoStrategy, strategyLoader, gameLogService)
        when:
            gameJob.run()
        then:
            1 * gameLogService.save({GameLog log -> log.winner == "playerTwo"})
    }
}
