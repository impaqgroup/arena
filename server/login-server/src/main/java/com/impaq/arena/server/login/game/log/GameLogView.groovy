package com.impaq.arena.server.login.game.log

import com.impaq.arena.server.engine.GameBoardView
import com.impaq.arena.player.Player
import com.impaq.arena.server.event.AttackBuilders
import com.impaq.arena.server.event.AttackCastle
import com.impaq.arena.server.event.AttackWarriors
import com.impaq.arena.server.event.AttackWizards
import com.impaq.arena.server.event.BuildCastle
import com.impaq.arena.server.event.GameEnd
import com.impaq.arena.server.event.GameStarted
import com.impaq.arena.server.event.PlayerTurnStart
import com.impaq.arena.server.event.RecruitBuilders
import com.impaq.arena.server.event.RecruitWarriors
import com.impaq.arena.server.event.RecruitWizards
import com.impaq.arena.server.event.RoundStart
import com.impaq.arena.server.event.SpyBuilders
import com.impaq.arena.server.event.SpyCastle
import com.impaq.arena.server.event.SpyWarriors
import com.impaq.arena.server.event.SpyWizards

class GameLogView implements GameBoardView {

    Player playerOne
    Player playerTwo

    final GameLog gameLog
    RoundLog roundLog
    PlayerLog playerLog

    GameLogView(gameLog = new GameLog()) {
        this.gameLog = gameLog
        this.roundLog = new RoundLog(roundNumber: 0, playerOneLog: new PlayerLog())
        this.playerLog = new PlayerLog()
    }

    @Override
    void onGameStart(GameStarted event) {
        playerOne = event.playerOne
        playerTwo = event.playerTwo
        gameLog.logGameStart(playerOne.getId(), playerTwo.getId())
    }

    @Override
    void onSpyWizards(SpyWizards event) {
        playerLog.actions.add("SPY_ENEMY_WIZARDS")
    }

    @Override
    void onSpyWarriors(SpyWarriors event) {
        playerLog.actions.add("SPY_ENEMY_WARRIORS")
    }

    @Override
    void onSpyCastle(SpyCastle event) {
        playerLog.actions.add("SPY_ENEMY_CASTLE")
    }

    @Override
    void onSpyBuilders(SpyBuilders event) {
        playerLog.actions.add("SPY_ENEMY_BUILDERS")
    }

    @Override
    void onBuildCastle(BuildCastle event) {
        playerLog.actions.add("BUILD_OWN_CASTLE")
    }

    @Override
    void onAttackCastle(AttackCastle event) {
        playerLog.actions.add("ATTACK_ENEMY_CASTLE")
    }

    @Override
    void onAttackBuilders(AttackBuilders event) {
        playerLog.actions.add("ATTACK_ENEMY_BUILDERS")
    }

    @Override
    void onAttackWizards(AttackWizards event) {
        playerLog.actions.add("ATTACK_ENEMY_WIZARDS")
    }

    @Override
    void onAttackWarriors(AttackWarriors event) {
        playerLog.actions.add("ATTACK_ENEMY_WARRIORS")
    }

    @Override
    void onRecruitBuilders(RecruitBuilders event) {
        playerLog.actions.add("RECRUIT_BUILDERS")
    }

    @Override
    void onRecruitWizards(RecruitWizards event) {
        playerLog.actions.add("RECRUIT_WIZARDS")
    }

    @Override
    void onRecruitWarriors(RecruitWarriors event) {
        playerLog.actions.add("RECRUIT_WARRIORS")
    }

    @Override
    void onRoundStart(RoundStart event) {
        finalizeRoundLog()
        roundLog = new RoundLog(roundNumber: event.number)
        playerLog = null
    }

    @Override
    void onPlayerTurnStart(PlayerTurnStart event) {
        if (playerLog != null) {
            roundLog.playerOneLog = playerLog
        }
        playerLog = new PlayerLog()
    }

    @Override
    void onGameEnd(GameEnd event) {
        finalizeRoundLog()
        gameLog.winner = event.winner?.getId()
    }

    private void finalizeRoundLog() {
        roundLog.playerTwoLog = playerLog
        finalizePlayerLog(roundLog.playerOneLog, playerOne)
        finalizePlayerLog(roundLog.playerTwoLog, playerTwo)
        gameLog.logNextRound(roundLog)
    }

    static void finalizePlayerLog(PlayerLog log, Player player) {
        log.castleHeight = player.castle.height
        log.buildersCount = player.builders.count
        log.wizardsCount = player.wizards.count
        log.warriorsCount = player.warriors.count
    }

}
