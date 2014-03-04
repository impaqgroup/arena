package com.impaq.arena.server.login.game.log

import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

public interface GameLogRepository extends JpaRepository<GameLog, Long> {

    @Query("from GameLog l where l.playerOne = ?1 or l.playerTwo = ?1 order by l.startDate asc")
    List<GameLog> findByPlayer(String playerId, Pageable pageable)

}