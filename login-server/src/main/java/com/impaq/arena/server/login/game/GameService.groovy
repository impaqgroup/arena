package com.impaq.arena.server.login.game

import com.impaq.arena.GameBoard
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

    private PlayerStrategyLoader strategyLoader;
    private GameLogService logService

    @Autowired
    GameService(PlayerStrategyLoader strategyLoader, GameLogService logService) {
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
            logGameError(playerOne, playerTwo, e)
        }
    }

    private void logGame(String playerOne, String playerTwo, String mode) {
        PlayerStrategy strategyOne = strategyLoader.loadPlayerStrategy(playerOne)
        PlayerStrategy strategyTwo = strategyLoader.loadOpponentStrategy(mode)

        GameBoard gameBoard = new GameBoard(
            playerOne, strategyOne,
            playerTwo, strategyTwo
        )

        GameLogView logView = new GameLogView()
        gameBoard.registerView(logView)
        gameBoard.startGame()

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
