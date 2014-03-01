package com.impaq.arena.server.login.game.log

import org.springframework.data.jpa.domain.AbstractPersistable

import javax.persistence.CollectionTable
import javax.persistence.ElementCollection
import javax.persistence.Entity

import static javax.persistence.FetchType.EAGER

@Entity
class PlayerLog extends AbstractPersistable<Long> {

    @ElementCollection(fetch = EAGER)
    @CollectionTable(name = "PlayerActions")
    List<String> actions = [];

    int castleHeight;

    int buildersCount;

    int imagesCount;

    int warriorsCount;

}
