package com.impaq.arena.server.login.player.strategy

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.*

@RestController
@RequestMapping("/player/strategy")
class PlayerStrategyResource {

    @RequestMapping(method = GET)
    PlayerStrategy downloadStrategy() {

    }

    @RequestMapping(method = PUT)
    void uploadStrategy(PlayerStrategy strategy) {

    }
}
