package com.impaq.arena.server.login.game

import com.impaq.arena.event.*
import com.impaq.arena.player.Player
import com.impaq.arena.server.login.game.log.GameLog
import spock.lang.Ignore
import spock.lang.Specification

class GameLogViewTest extends Specification {

    String playerOneId = "playerOneId"
    Player playerOne = new Player(null, null, null, null, null)

    String playerTwoId = "playerTwoId"
    Player playerTwo = new Player(null, null, null, null, null)
    GameLog gameLog = Mock()

    GameLogView view = new GameLogView(gameLog, playerOneId, playerOne, playerTwoId, playerTwo)

    def "Should log game start"() {
        when:
            view.onGameStart(new GameStarted(playerOne, playerTwo))
        then:
            1 * gameLog.logGameStart(playerOneId, playerTwoId)
    }

    def "Should log next round start"() {
        when:
            view.onRoundStart(new RoundStart(0))
        then:
            1 * gameLog.logNextRound()
    }

    def "Should log wizard spy action executed by first player"() {
        when:
            view.onSpyWizards(new SpyWizards(playerOne))
        then:
            1 * gameLog.logFirstPlayerAction("${playerOneId} is checking enemy wizards.")
    }

    def "Should log wizard spy action executed by second player"() {
        when:
            view.onSpyWizards(new SpyWizards(playerTwo))
        then:
            1 * gameLog.logSecondPlayerAction("${playerTwoId} is checking enemy wizards.")
    }

    def "Should log warriors spy action executed by first player"() {
        when:
            view.onSpyWarriors(new SpyWarriors(playerOne))
        then:
            1 * gameLog.logFirstPlayerAction("${playerOneId} is checking enemy warriors.")
    }

    def "Should log warriors spy action executed by second player"() {
        when:
            view.onSpyWarriors(new SpyWarriors(playerTwo))
        then:
            1 * gameLog.logSecondPlayerAction("${playerTwoId} is checking enemy warriors.")
    }

    def "Should log builders spy action executed by first player"() {
        when:
            view.onSpyBuilders(new SpyBuilders(playerOne))
        then:
            1 * gameLog.logFirstPlayerAction("${playerOneId} is checking enemy builders.")
    }

    def "Should log builders spy action executed by second player"() {
        when:
            view.onSpyBuilders(new SpyBuilders(playerTwo))
        then:
            1 * gameLog.logSecondPlayerAction("${playerTwoId} is checking enemy builders.")
    }

    def "Should log castle spy action executed by first player"() {
        when:
            view.onSpyCastle(new SpyCastle(playerOne))
        then:
            1 * gameLog.logFirstPlayerAction("${playerOneId} is checking enemy castle.")
    }

    def "Should log castle spy action executed by second player"() {
        when:
            view.onSpyCastle(new SpyCastle(playerTwo))
        then:
            1 * gameLog.logSecondPlayerAction("${playerTwoId} is checking enemy castle.")
    }

    def "Should log player one as a winner"() {
        when:
            view.onWinner(new Winner(playerOne))
        then:
            1 * gameLog.logWinner(playerOneId)
    }

    def "Should log player two as a winner"() {
        when:
            view.onWinner(new Winner(playerTwo))
        then:
            1 * gameLog.logWinner(playerTwoId)
    }
}
