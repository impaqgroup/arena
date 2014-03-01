package com.impaq.arena.server.login.game

import com.impaq.arena.GameBoardView
import com.impaq.arena.event.*
import com.impaq.arena.player.Player
import com.impaq.arena.server.login.game.log.GameLog

class GameLogView implements GameBoardView {

    private final GameLog gameLog
    private final String playerOneId
    private final String playerTwoId
    private final Player playerOne
    private final Player playerTwo

    GameLogView(gameLog = new GameLog(), String playerOneId, Player playerOne, String playerTwoId, Player playerTwo) {
        this.gameLog = gameLog

        this.playerOneId = playerOneId
        this.playerOne = playerOne

        this.playerTwoId = playerTwoId
        this.playerTwo = playerTwo
    }

    @Override
    void onGameStart(GameStarted event) {
        gameLog.logGameStart(playerOneId, playerTwoId)
    }

    @Override
    void onWinner(Winner winner) {
        if (winner.winner == playerOne) {
            gameLog.logWinner(playerOneId)
        } else {
            gameLog.logWinner(playerTwoId)
        }
    }

    @Override
    void onSpyWizards(SpyWizards event) {
        onSpyEvent(event, "is checking enemy wizards")
    }

    private onSpyEvent(BaseEvent event, String message) {
        if(playerOne == event.getPlayer()) {
            gameLog.logFirstPlayerAction("${playerOneId} ${message}.")
        } else {
            gameLog.logSecondPlayerAction("${playerTwoId} ${message}.")
        }
    }

    @Override
    void onSpyWarriors(SpyWarriors event) {
        onSpyEvent(event, "is checking enemy warriors")
    }

    @Override
    void onSpyCastle(SpyCastle event) {
        onSpyEvent(event, "is checking enemy castle")
    }

    @Override
    void onSpyBuilders(SpyBuilders event) {
        onSpyEvent(event, "is checking enemy builders")
    }

    @Override
    void onBuildCastle(BuildCastle event) {

    }

    @Override
    void onDestroyCastel(DestroyCastle event) {

    }

    @Override
    void onKillBuilders(KillBuilders event) {

    }

    @Override
    void onKillWizards(KillWizards event) {

    }

    @Override
    void onKillWarriors(KillWarriors event) {

    }

    @Override
    void onAddBuilders(AddBuilders event) {

    }

    @Override
    void onAddWizards(AddWizards event) {

    }

    @Override
    void onAddWarriors(AddWarriors event) {

    }

    @Override
    void onRoundStart(RoundStart event) {
        gameLog.logNextRound()
    }
}
