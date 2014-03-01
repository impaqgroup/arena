package com.impaq.arena.server.login.game

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.POST

@RestController
@RequestMapping("/game")
class GameResource {

    @RequestMapping(method = POST)
    void runGame() {

    }

}
