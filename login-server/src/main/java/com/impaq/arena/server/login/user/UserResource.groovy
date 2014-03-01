package com.impaq.arena.server.login.user

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.web.bind.annotation.RequestMethod.*

@RestController
@RequestMapping("/user")
class UserResource {

    @RequestMapping(method = GET)
    User view() {

    }

    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    void register(User user) {

    }

    @RequestMapping(method = PUT)
    void update(User user) {

    }

}
