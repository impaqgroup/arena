package com.impaq.arena.server.login.game

import com.impaq.arena.GameBoard
import com.impaq.arena.server.login.game.log.GameLogService
import com.impaq.arena.server.login.game.log.GameLogView
import com.impaq.arena.server.login.player.strategy.PlayerStrategy

class GameJob implements Runnable {

    private final PlayerStrategy playerOneStrategy
    private final PlayerStrategy playerTwoStrategy
    private final PlayerStrategyLoader strategyLoader
    private final GameLogService gameLogService

    GameJob(PlayerStrategy playerOneStrategy, PlayerStrategy playerTwoStrategy,
            PlayerStrategyLoader strategyLoader,  GameLogService gameLogService) {
        this.playerOneStrategy = playerOneStrategy
        this.playerTwoStrategy = playerTwoStrategy
        this.strategyLoader = strategyLoader
        this.gameLogService = gameLogService
    }

    @Override
    void run() {
        com.impaq.arena.api.PlayerStrategy strategyOne =
            strategyLoader.loadStrategy(playerOneStrategy.className, playerOneStrategy.javaCode)
        com.impaq.arena.api.PlayerStrategy strategyTwo =
            strategyLoader.loadStrategy(playerTwoStrategy.className, playerTwoStrategy.javaCode)

        GameBoard gameBoard = new GameBoard(
            playerOneStrategy.getPlayerId(), strategyOne,
            playerTwoStrategy.getPlayerId(), strategyTwo
        )

        GameLogView logView = new GameLogView()
        gameBoard.registerView(logView)
        gameBoard.startGame()
        gameLogService.save(logView.gameLog)
    }
}
