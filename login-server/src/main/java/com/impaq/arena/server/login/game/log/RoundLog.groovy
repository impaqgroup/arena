package com.impaq.arena.server.login.game.log

import org.springframework.data.jpa.domain.AbstractPersistable

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

import static javax.persistence.CascadeType.ALL
import static javax.persistence.FetchType.EAGER

@Entity
class RoundLog extends AbstractPersistable<Long> {

    int roundNumber;

    @ManyToOne(cascade = ALL, fetch = EAGER)
    @JoinColumn(name = "playerOneLog")
    PlayerLog playerOneLog = new PlayerLog();

    @ManyToOne(cascade = ALL, fetch = EAGER)
    @JoinColumn(name = "playerTwoLog")
    PlayerLog playerTwoLog = new PlayerLog();

}
