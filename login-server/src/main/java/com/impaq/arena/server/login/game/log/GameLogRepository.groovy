package com.impaq.arena.server.login.game.log

import org.springframework.data.jpa.repository.JpaRepository

public interface GameLogRepository extends JpaRepository<GameLog, Long> {

}