package com.impaq.arena.server.login.game.log

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

import javax.transaction.Transactional

@Service
@Transactional
class GameLogService {

    private final GameLogRepository repository

    @Autowired
    GameLogService(GameLogRepository repository) {
        this.repository = repository
    }

    GameLog lastGameLog(String userId) {
        List<GameLog> logs = repository.findByPlayer(userId, new PageRequest(0, 1))
        return logs.isEmpty() ? null : logs.get(0)
    }

    void save(GameLog gameLog) {
        repository.save(gameLog)
    }
}
