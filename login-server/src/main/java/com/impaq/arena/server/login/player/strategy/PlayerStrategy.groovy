package com.impaq.arena.server.login.player.strategy

import org.hibernate.validator.constraints.NotEmpty
import org.joda.time.DateTime

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class PlayerStrategy {

    @Id
    String playerId;

    @NotEmpty
    String implementation;

    DateTime lastUpdated;

}
