package com.impaq.arena.server.login.game

import com.impaq.arena.GameBoard
import com.impaq.arena.server.login.game.log.GameLogResource
import com.impaq.arena.server.login.game.log.GameLogService
import com.impaq.arena.server.login.game.log.GameLogView
import com.impaq.arena.server.login.player.strategy.PlayerStrategy

class GameJob implements Runnable {

    private final JavaCompiler javaCompiler = new JavaCompiler()
    private final GameLogService gameLogService
    private final PlayerStrategy playerOneStrategy
    private final PlayerStrategy playerTwoStrategy

    GameJob(PlayerStrategy playerOneStrategy, PlayerStrategy playerTwoStrategy, GameLogService gameLogService) {
        this.playerOneStrategy = playerOneStrategy
        this.playerTwoStrategy = playerTwoStrategy
        this.gameLogService = gameLogService
    }

    @Override
    void run() {
        Class<?> strategyOneClazz = javaCompiler.compile(playerOneStrategy.className, playerOneStrategy.javaCode)
        Object strategyOne = strategyOneClazz.newInstance()
        Class<?> strategyTwoClazz = javaCompiler.compile(playerTwoStrategy.className, playerTwoStrategy.javaCode)
        Object strategyTwo = strategyTwoClazz.newInstance()

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
