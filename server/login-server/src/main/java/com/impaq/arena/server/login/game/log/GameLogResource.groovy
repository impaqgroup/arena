package com.impaq.arena.server.login.game.log

import com.impaq.arena.server.login.user.CurrentUser
import com.impaq.arena.server.login.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
@RequestMapping("/game/log")
class GameLogResource {

    private final GameLogService service

    @Autowired
    GameLogResource(GameLogService service) {
        this.service = service
    }

    @RequestMapping(method = GET)
    GameLog lastGameLog(@CurrentUser User user) {
        return service.lastGameLog(user.email)
    }
}
