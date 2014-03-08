package com.impaq.arena.server.login.player.strategy

import org.hibernate.validator.constraints.NotEmpty
import org.joda.time.DateTime

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Lob
import javax.validation.constraints.NotNull

@Entity
class PlayerStrategy {

    @Id
    @NotNull
    String playerId

    @NotEmpty
    String className

    @Lob
    @NotEmpty
    String javaCode

    DateTime lastUpdated

}
