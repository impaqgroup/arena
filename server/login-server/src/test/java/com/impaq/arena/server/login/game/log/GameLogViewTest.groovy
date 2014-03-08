package com.impaq.arena.server.login.game.log

import com.impaq.arena.player.Player
import com.impaq.arena.server.event.GameEnd
import com.impaq.arena.server.event.GameStarted
import com.impaq.arena.server.event.PlayerTurnStart
import com.impaq.arena.server.event.RoundStart
import com.impaq.arena.server.event.SpyBuilders
import com.impaq.arena.server.event.SpyCastle
import com.impaq.arena.server.event.SpyWarriors
import com.impaq.arena.server.event.SpyWizards
import spock.lang.Specification

class GameLogViewTest extends Specification {

    String playerOneId = "playerOneId"
    Player playerOne = new Player(playerOneId, null)

    String playerTwoId = "playerTwoId"
    Player playerTwo = new Player(playerTwoId, null)

    GameLog gameLog = new GameLog()
    GameLogView view = new GameLogView(gameLog)

    def "Should log game start"() {
        when:
            view.onGameStart(new GameStarted(playerOne, playerTwo))
        then:
            gameLog.playerOne == playerOneId
            gameLog.playerTwo == playerTwoId
    }

    def "Should start stats on first round start"() {
        when:
            view.onGameStart(new GameStarted(playerOne, playerTwo))
            view.onRoundStart(new RoundStart(1))
        then:
            gameLog.roundLogs.size() == 1
            // FIXME remove duplication
            gameLog.roundLogs[0].playerOneLog.actions == []
            gameLog.roundLogs[0].playerOneLog.castleHeight == 30
            gameLog.roundLogs[0].playerOneLog.buildersCount == 2
            gameLog.roundLogs[0].playerOneLog.wizardsCount == 3
            gameLog.roundLogs[0].playerOneLog.warriorsCount == 6

            gameLog.roundLogs[0].playerTwoLog.actions == []
            gameLog.roundLogs[0].playerTwoLog.castleHeight == 30
            gameLog.roundLogs[0].playerTwoLog.buildersCount == 2
            gameLog.roundLogs[0].playerTwoLog.wizardsCount == 3
            gameLog.roundLogs[0].playerTwoLog.warriorsCount == 6
    }

    def "Should log spy actions"() {
        when:
            view.onGameStart(new GameStarted(playerOne, playerTwo))
            view.onRoundStart(new RoundStart(1))
            view.onPlayerTurnStart(new PlayerTurnStart(playerOne))
            view.onSpyCastle(new SpyCastle(playerOne))
            view.onSpyWarriors(new SpyWarriors(playerOne))
            view.onPlayerTurnStart(new PlayerTurnStart(playerTwo))
            view.onSpyBuilders(new SpyBuilders(playerOne))
            view.onSpyWizards(new SpyWizards(playerOne))
            view.onRoundStart(new RoundStart(2))
        then:
            gameLog.roundLogs.size() == 2
            gameLog.roundLogs[1].playerOneLog.actions == ["SPY_ENEMY_CASTLE", "SPY_ENEMY_WARRIORS"]
            gameLog.roundLogs[1].playerTwoLog.actions == ["SPY_ENEMY_BUILDERS", "SPY_ENEMY_WIZARDS"]
    }

    def "Should log player one as a winner"() {
        when:
            view.onGameStart(new GameStarted(playerOne, playerTwo))
            view.onRoundStart(new RoundStart(1))
            view.onPlayerTurnStart(new PlayerTurnStart(playerOne))
            view.onPlayerTurnStart(new PlayerTurnStart(playerTwo))
            view.onGameEnd(new GameEnd(playerOne))
        then:
            gameLog.winner == playerOneId
    }

    def "Should log player two as a winner"() {
        when:
            view.onGameStart(new GameStarted(playerOne, playerTwo))
            view.onRoundStart(new RoundStart(1))
            view.onPlayerTurnStart(new PlayerTurnStart(playerOne))
            view.onPlayerTurnStart(new PlayerTurnStart(playerTwo))
            view.onGameEnd(new GameEnd(playerTwo))
        then:
            gameLog.winner == playerTwoId
    }

    def "Should log draw"() {
        when:
            view.onGameStart(new GameStarted(playerOne, playerTwo))
            view.onRoundStart(new RoundStart(1))
            view.onPlayerTurnStart(new PlayerTurnStart(playerOne))
            view.onPlayerTurnStart(new PlayerTurnStart(playerTwo))
            view.onGameEnd(new GameEnd(null))
        then:
            gameLog.winner == null
    }
}
