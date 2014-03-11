package com.impaq.arena.server.login.user

import groovy.transform.TypeChecked
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

@TypeChecked
class Admin extends User {

    @Override
    Collection<? extends GrantedAuthority> getAuthorities() {
        return [new SimpleGrantedAuthority("ROLE_ADMIN")]
    }

    boolean isAdmin() {
        return true
    }
}
