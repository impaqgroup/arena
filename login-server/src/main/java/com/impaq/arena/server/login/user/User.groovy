package com.impaq.arena.server.login.user

import org.hibernate.validator.constraints.*
import org.joda.time.DateTime

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class User {

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
    int term;

    DateTime created;

    DateTime lastUpdated;

}
