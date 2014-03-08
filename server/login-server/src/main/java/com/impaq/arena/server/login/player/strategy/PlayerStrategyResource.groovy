package com.impaq.arena.server.login.player.strategy

import com.impaq.arena.server.login.user.CurrentUser
import com.impaq.arena.server.login.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.PUT

@RestController
@RequestMapping("/player/strategy")
class PlayerStrategyResource {

    private final PlayerStrategyService service

    @Autowired
    PlayerStrategyResource(PlayerStrategyService service) {
        this.service = service
    }

    @RequestMapping(method = GET)
    PlayerStrategy downloadStrategy(@CurrentUser User user) {
        return service.findOne(user.email)
    }

    @RequestMapping(method = PUT)
    void uploadStrategy(@CurrentUser User user, @RequestBody PlayerStrategy strategy) {
        strategy.playerId = user.email
        service.createOrUpdate(strategy)
    }
}
