package com.impaq.arena.server.login.game.log

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.transaction.Transactional

@Service
@Transactional
class GameLogService {

    private final GameLogRepository gameLogRepository

    @Autowired
    GameLogService(GameLogRepository gameLogRepository) {
        this.gameLogRepository = gameLogRepository
    }

    void save(GameLog gameLog) {
        gameLogRepository.save(gameLog)
    }
}
