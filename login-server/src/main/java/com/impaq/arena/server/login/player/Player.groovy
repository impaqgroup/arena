package com.impaq.arena.server.login.player

import groovy.transform.TypeChecked
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotEmpty
import org.hibernate.validator.constraints.Range
import org.jadira.usertype.dateandtime.joda.PersistentDateTime
import org.joda.time.DateTime

import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.NotNull

@Entity
@TypeDefs([
    @TypeDef(name = "dateTime", defaultForType = DateTime.class, typeClass = PersistentDateTime.class)
])
@TypeChecked
class Player {

    @Id
    @NotNull
    @Email
    String email;

    @NotEmpty
    String password;

    @NotEmpty
    String name;

    @NotEmpty
    String surname;

    @NotNull
    @Range(min = 1L, max = 12L)
    Integer term;

    DateTime created;

    DateTime lastUpdated;
}
