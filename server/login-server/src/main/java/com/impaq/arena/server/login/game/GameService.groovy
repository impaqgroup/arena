package com.impaq.arena.server.login.game

import com.impaq.arena.engine.GameConfig
import com.impaq.arena.engine.SimpleGameBoard
import com.impaq.arena.api.PlayerStrategy
import com.impaq.arena.server.login.game.log.GameLog
import com.impaq.arena.server.login.game.log.GameLogService
import com.impaq.arena.server.login.game.log.GameLogView
import groovy.util.logging.Log
import org.joda.time.DateTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Log
@Service
class GameService {

    private final GameConfig gameConfig
    private final PlayerStrategyLoader strategyLoader;
    private final GameLogService logService

    @Autowired
    GameService(GameConfig gameConfig, PlayerStrategyLoader strategyLoader, GameLogService logService) {
        this.gameConfig = gameConfig
        this.strategyLoader = strategyLoader
        this.logService = logService
    }

    @Async
    void play(String userId, String mode = "test") {
        String playerOne = userId
        String playerTwo = "test"
        try {
            logGame(playerOne, playerTwo, mode)
        } catch (Throwable e) {
            log.log(java.util.logging.Level.SEVERE, "!!!", e)
            logGameError(playerOne, playerTwo, e)
        }
    }

    private void logGame(String playerOne, String playerTwo, String mode) {
        PlayerStrategy strategyOne = strategyLoader.loadPlayerStrategy(playerOne)
        PlayerStrategy strategyTwo = strategyLoader.loadOpponentStrategy(mode)

        SimpleGameBoard gameBoard = new SimpleGameBoard(
            gameConfig,
            playerOne, strategyOne,
            playerTwo, strategyTwo
        )

        GameLogView logView = new GameLogView()
        gameBoard.registerView(logView)
        gameBoard.playGame()

        logService.save(logView.gameLog)
    }

    private void logGameError(String playerOne, String playerTwo, Throwable e) {
        logService.save(new GameLog(
            startDate: DateTime.now(),
            playerOne: playerOne,
            playerTwo: playerTwo,
            gameError: e.getMessage()))
    }
}
