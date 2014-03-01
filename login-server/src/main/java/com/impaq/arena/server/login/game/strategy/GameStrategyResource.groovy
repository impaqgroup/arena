package com.impaq.arena.server.login.game.strategy

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.*

@RestController
@RequestMapping("/game/strategy")
class GameStrategyResource {

    @RequestMapping(method = GET)
    GameStrategy downloadStrategy() {

    }

    @RequestMapping(method = PUT)
    void uploadStrategy(GameStrategy strategy) {

    }
}
