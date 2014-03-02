package com.impaq.arena.server.login.game.log

import com.impaq.arena.GameBoardView
import com.impaq.arena.event.*
import com.impaq.arena.player.Player

class GameLogView implements GameBoardView {

    final GameLog gameLog

    RoundLog roundLog
    Player player
    PlayerLog playerLog;

    GameLogView(gameLog = new GameLog()) {
        this.gameLog = gameLog
    }

    @Override
    void onGameStart(GameStarted event) {
        gameLog.logGameStart(event.getPlayerOne().getId(), event.getPlayerTwo().getId())
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
        if (roundLog != null) {
            finalizeRoundLog()
        }
        roundLog = new RoundLog(roundNumber: event.number)
        playerLog = null
    }

    @Override
    void onPlayerTurnStart(PlayerTurnStart event) {
        if (playerLog != null) {
            finalizePlayerLog()
            roundLog.playerOneLog = playerLog
        }
        player = event.player
        playerLog = new PlayerLog()
    }

    @Override
    void onGameEnd(GameEnd event) {
        finalizeRoundLog()
        gameLog.winner = event.winner?.getId()
    }

    private void finalizeRoundLog() {
        finalizePlayerLog()
        roundLog.playerTwoLog = playerLog
        gameLog.logNextRound(roundLog)
    }

    void finalizePlayerLog() {
        playerLog.castleHeight = player.castle.height
        playerLog.buildersCount = player.builders.count
        playerLog.wizardsCount = player.wizards.count
        playerLog.warriorsCount = player.warriors.count
    }

}
