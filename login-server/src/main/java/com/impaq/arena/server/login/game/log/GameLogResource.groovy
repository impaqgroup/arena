package com.impaq.arena.server.login.game.log

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
@RequestMapping("/game/log")
class GameLogResource {

    @RequestMapping(method = GET)
    void lastGameLog() {

    }
}
