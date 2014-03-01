package com.impaq.arena.server.login.player

import com.impaq.arena.server.login.user.CurrentUser
import com.impaq.arena.server.login.user.User
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.web.bind.annotation.RequestMethod.*

@RestController
@RequestMapping("/player")
class PlayerResource {

    private final PlayerService service

    PlayerResource(PlayerService service) {
        this.service = service
    }

    @RequestMapping(method = GET)
    Player view(@CurrentUser User user) {
        return service.findById(user.email)
    }

    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    void register(Player player) {
        service.create(player)
    }

    @RequestMapping(method = PUT)
    void update(Player player, @CurrentUser User user) {
        player.setEmail(user.getEmail())
        service.update(player)
    }

}
