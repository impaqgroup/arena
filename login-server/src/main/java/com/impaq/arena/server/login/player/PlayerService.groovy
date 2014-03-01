package com.impaq.arena.server.login.player

import com.impaq.arena.server.login.util.Copy
import groovy.transform.TypeChecked
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.ResponseStatus

import static org.joda.time.DateTime.now
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import static org.springframework.transaction.annotation.Propagation.SUPPORTS

@Service
class PlayerService {

    private final PlayerRepository repository

    @Autowired
    PlayerService(PlayerRepository repository) {
        this.repository = repository
    }

    @Transactional(propagation = SUPPORTS, readOnly = true)
    Player findById(String email) {
        return repository.findOne(email);
    }

    @Transactional
    void create(Player player) {
        if (repository.findOne(player.email)) {
            throw new PlayerAlreadyExistsException()
        }
        player.setCreated(now())
        player.setLastUpdated(now())
        repository.save(player)
    }

    void update(Player player) {
        Player saved = repository.findOne(player.email)
        use(Copy, { player.copyTo(saved, ["name", "surname", "term"]) })
        saved.setLastUpdated(now())
        repository.save(saved)
    }

    @ResponseStatus(value = UNPROCESSABLE_ENTITY, reason = "User with given email already exists!")
    static class PlayerAlreadyExistsException extends RuntimeException { }
}
