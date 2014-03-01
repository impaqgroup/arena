package com.impaq.arena.server.login.player

import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotEmpty
import org.hibernate.validator.constraints.Range
import org.joda.time.DateTime

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Player {

    @Id
    @Email
    String email;

    @NotEmpty
    String password;

    @NotEmpty
    String name;

    @NotEmpty
    String surname;

    @Range(min = 1L, max = 12L)
    Integer term;

    DateTime created;

    DateTime lastUpdated;
}
