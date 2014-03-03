package com.impaq.arena.server.login.game

import com.impaq.arena.server.login.user.CurrentUser
import com.impaq.arena.server.login.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.POST

@RestController
@RequestMapping("/game")
class GameResource {

    private final GameService service

    @Autowired
    GameResource(GameService service) {
        this.service = service
    }

    @RequestMapping(method = POST)
    void runGame(@CurrentUser User user, @RequestBody Game game) {
        service.play(user.getEmail(), game.mode)
    }

}
