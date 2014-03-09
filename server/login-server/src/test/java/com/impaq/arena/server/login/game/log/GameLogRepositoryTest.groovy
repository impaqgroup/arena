package com.impaq.arena.server.login.game.log

import com.impaq.arena.server.login.IntegrationSpecification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.transaction.annotation.Transactional

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

import static org.joda.time.DateTime.now

@Transactional
class GameLogRepositoryTest extends IntegrationSpecification {

    @PersistenceContext
    EntityManager entityManager

    @Autowired
    GameLogRepository repository

    def "Should save full game log"() {
        given:
            GameLog log = new GameLog(
                startDate: now(),
                playerOne: "testPlayerOne",
                playerTwo: "testPlayerTwo",
                roundLogs: [
                    new RoundLog(
                        roundNumber: 1,
                        playerOneLog: new PlayerLog(
                            actions: ["SPY_ENEMY_BUILDERS", "BUILD_MY_CASTLE", "ATTACK_ENEMY_CASTLE"],
                            castleHeight: 34,
                            warriorsCount: 6,
                            wizardsCount: 3,
                            buildersCount: 3
                        ),
                        playerTwoLog: new PlayerLog()
                    )
                ]
            )
        when:
            repository.saveAndFlush(log)
            entityManager.clear()
            GameLog logged = repository.findByPlayer("testPlayerOne", new PageRequest(0, 1))[0]
        then:
            !log.is(logged)
            logged.playerOne == "testPlayerOne"
            logged.roundLogs[0].roundNumber == 1
            logged.roundLogs[0].playerOneLog.actions == ["SPY_ENEMY_BUILDERS", "BUILD_MY_CASTLE", "ATTACK_ENEMY_CASTLE"]
    }

}
