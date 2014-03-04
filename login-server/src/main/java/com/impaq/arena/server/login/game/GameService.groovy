package com.impaq.arena.server.login.game

import com.impaq.arena.GameBoard
import com.impaq.arena.api.PlayerStrategy
import com.impaq.arena.server.login.game.log.GameLogService
import com.impaq.arena.server.login.game.log.GameLogView
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

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
        PlayerStrategy strategyOne = strategyLoader.loadPlayerStrategy(userId)
        PlayerStrategy strategyTwo = strategyLoader.loadOpponentStrategt(mode)

        GameBoard gameBoard = new GameBoard(
            userId, strategyOne,
            "test", strategyTwo
        )

        GameLogView logView = new GameLogView()
        gameBoard.registerView(logView)
        gameBoard.startGame()

        logService.save(logView.gameLog)
    }
}
