package com.impaq.arena.server.login.game

import com.impaq.arena.server.login.game.log.GameLog
import com.impaq.arena.server.login.game.log.GameLogService
import com.impaq.arena.server.login.player.strategy.PlayerStrategy
import spock.lang.Ignore
import spock.lang.Specification

class GameJobTest extends Specification {
    private final String activeStrategyCode = getClass().getClassLoader().getResourceAsStream("ExampleStrategy.java").getText()
    private final String idleStrategyCode = getClass().getClassLoader().getResourceAsStream("ExampleStrategy_idle.java").getText()
    private final GameLogService gameLogService = Mock()
    private PlayerStrategy playerOneStrategy = new PlayerStrategy(
        className: "ExampleStrategy", playerId: "playerOne")
    private PlayerStrategy playerTwoStrategy = new PlayerStrategy(
        className: "ExampleStrategy", playerId: "playerTwo")

    def "Should run game in which player one is a winner"() {
        given:
            playerOneStrategy.javaCode = activeStrategyCode
            playerTwoStrategy.javaCode = idleStrategyCode
            GameJob gameJob = new GameJob(playerOneStrategy, playerTwoStrategy, gameLogService)
        when:
            gameJob.run()
        then:
            1 * gameLogService.save({GameLog log -> log.winner == "playerOne"})
    }

    def "Should run game in which player two is a winner"() {
        given:
            playerOneStrategy.javaCode = idleStrategyCode
            playerTwoStrategy.javaCode = activeStrategyCode
            GameJob gameJob = new GameJob(playerOneStrategy, playerTwoStrategy, gameLogService)
        when:
            gameJob.run()
        then:
            1 * gameLogService.save({GameLog log -> log.winner == "playerTwo"})
    }
}
