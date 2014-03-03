package com.impaq.arena.server.login.game

import com.impaq.arena.server.login.game.log.GameLogService
import com.impaq.arena.server.login.player.strategy.PlayerStrategyService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
class GameService {

    private PlayerStrategyService strategyService
    private GameLogService logService

    @Autowired
    GameService(PlayerStrategyService strategyService, GameLogService logService) {
        this.strategyService = strategyService
        this.logService = logService
    }

    @Async
    void play(String userId, String mode = "test") {

    }
}
