package com.impaq.arena.server.login.game.strategy

import org.hibernate.validator.constraints.NotEmpty
import org.joda.time.DateTime

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class GameStrategy {

    @Id
    String playerId;

    @NotEmpty
    String implementation;

    DateTime lastUpdated;

}
