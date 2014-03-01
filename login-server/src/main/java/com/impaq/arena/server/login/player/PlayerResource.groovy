package com.impaq.arena.server.login.player

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.web.bind.annotation.RequestMethod.*

@RestController
@RequestMapping("/player")
class PlayerResource {

    @RequestMapping(method = GET)
    Player view() {

    }

    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    void register(Player player) {

    }

    @RequestMapping(method = PUT)
    void update(Player player) {

    }

}
