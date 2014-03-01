package com.impaq.arena.server.login.game.log

import org.joda.time.DateTime
import org.springframework.data.jpa.domain.AbstractPersistable

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

import static javax.persistence.CascadeType.ALL
import static javax.persistence.FetchType.EAGER

@Entity
class GameLog extends AbstractPersistable<Long> {

    DateTime startDate;

    String playerOne;

    String playerTwo;

    @OneToMany(cascade = ALL, fetch = EAGER)
    @JoinColumn(name = "gameLogId")
    List<RoundLog> roundLogs = [];

    String winner;

    private int roundNumber = -1;

    void logGameStart(String playerOneId, String playerTwoId) {
        startDate = new DateTime()
        playerOne = playerOneId
        playerTwo = playerTwoId
    }

    void logNextRound() {
        roundNumber++;
        roundLogs.add(new RoundLog(roundNumber: roundNumber))
    }

    void logFirstPlayerAction(String action) {
        roundLogs[roundNumber].playerOneLog.actions.add(action)
    }

    void logSecondPlayerAction(String action) {
        roundLogs[roundNumber].playerTwoLog.actions.add(action)
    }

    void logWinner(String winner) {
        this.winner = winner
    }
}
