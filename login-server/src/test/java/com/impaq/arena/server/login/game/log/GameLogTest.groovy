package com.impaq.arena.server.login.game.log

import org.joda.time.DateTime
import org.joda.time.DateTimeUtils
import spock.lang.Specification

class GameLogTest extends Specification {

    GameLog gameLog = new GameLog()

    def "Should log game start"() {
        given:
            DateTimeUtils.setCurrentMillisFixed(0)
        when:
            gameLog.logGameStart("player-1-id", "player-2-id")
        then:
            gameLog.startDate == new DateTime()
            gameLog.playerOne == "player-1-id"
            gameLog.playerTwo == "player-2-id"
    }

    def "Should create players logs for first round"() {
        when:
            gameLog.logNextRound();
        then:
            gameLog.roundLogs[0]
            gameLog.roundLogs[0].roundNumber == 0
            gameLog.roundLogs[0].playerOneLog
            gameLog.roundLogs[0].playerTwoLog
    }

    def "Should create players logs for next rounds"() {
        when:
            gameLog.logNextRound()
            gameLog.logNextRound()
        then:
            gameLog.roundLogs[0]
            gameLog.roundLogs[0].roundNumber == 0
            gameLog.roundLogs[0].playerOneLog
            gameLog.roundLogs[0].playerTwoLog
            gameLog.roundLogs[1]
            gameLog.roundLogs[1].roundNumber == 1
            gameLog.roundLogs[1].playerOneLog
            gameLog.roundLogs[1].playerTwoLog
    }

    def "Should log first player action in first round"() {
        given:
            gameLog.logNextRound()
        when:
            gameLog.logFirstPlayerAction("spy wizards")
        then:
            gameLog.roundLogs[0].playerOneLog.actions[0] == "spy wizards"
    }

    def "Should log first player actions in first round"() {
        given:
            gameLog.logNextRound()
        when:
            gameLog.logFirstPlayerAction("spy wizards")
            gameLog.logFirstPlayerAction("spy builders")
        then:
            gameLog.roundLogs[0].playerOneLog.actions[0] == "spy wizards"
            gameLog.roundLogs[0].playerOneLog.actions[1] == "spy builders"
    }

    def "Should log first player actions in next rounds"() {
        given:
            gameLog.logNextRound()
            gameLog.logNextRound()
        when:
            gameLog.logFirstPlayerAction("spy wizards")
            gameLog.logFirstPlayerAction("spy builders")
        then:
            gameLog.roundLogs[1].playerOneLog.actions[0] == "spy wizards"
            gameLog.roundLogs[1].playerOneLog.actions[1] == "spy builders"
    }

    def "Should log second player action in first round"() {
        given:
            gameLog.logNextRound()
        when:
            gameLog.logSecondPlayerAction("spy wizards")
        then:
            gameLog.roundLogs[0].playerTwoLog.actions[0] == "spy wizards"
    }

    def "Should log second player actions in first round"() {
        given:
            gameLog.logNextRound()
        when:
            gameLog.logSecondPlayerAction("spy wizards")
            gameLog.logSecondPlayerAction("spy builders")
        then:
            gameLog.roundLogs[0].playerTwoLog.actions[0] == "spy wizards"
            gameLog.roundLogs[0].playerTwoLog.actions[1] == "spy builders"
    }

    def "Should log second player actions in next rounds"() {
        given:
            gameLog.logNextRound()
            gameLog.logNextRound()
        when:
            gameLog.logSecondPlayerAction("spy wizards")
            gameLog.logSecondPlayerAction("spy builders")
        then:
            gameLog.roundLogs[1].playerTwoLog.actions[0] == "spy wizards"
            gameLog.roundLogs[1].playerTwoLog.actions[1] == "spy builders"
    }
}
