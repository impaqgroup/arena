package com.impaq.arena.server.login.player

import com.impaq.arena.server.login.util.Copy
import groovy.transform.TypeChecked
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.ResponseStatus

import javax.validation.Valid

import static groovy.transform.TypeCheckingMode.SKIP
import static org.joda.time.DateTime.now
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import static org.springframework.transaction.annotation.Propagation.SUPPORTS

@Service
@Validated
@TypeChecked
class PlayerService {

    private PlayerRepository repository

    private PasswordEncoder passwordEncoder

    protected PlayerService() { }

    @Autowired
    PlayerService(PlayerRepository repository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder
        this.repository = repository
    }

    @Transactional(propagation = SUPPORTS, readOnly = true)
    Player findById(String email) {
        return repository.findOne(email);
    }

    @Transactional
    void create(@Valid Player player) {
        if (repository.findOne(player.email)) {
            throw new PlayerAlreadyExistsException()
        }
        player.setPassword(passwordEncoder.encode(player.getPassword()))
        player.setCreated(now())
        player.setLastUpdated(now())
        repository.save(player)
    }

    @Transactional
    @TypeChecked(SKIP)
    void update(Player player) {
        Player saved = repository.findOne(player.email)
        use(Copy, { player.copyTo(saved, ["name", "surname", "term"]) })
        if (player.password != null) {
            saved.password = passwordEncoder.encode(player.password)
        }
        saved.setLastUpdated(now())
        repository.save(saved)
    }

    @ResponseStatus(value = UNPROCESSABLE_ENTITY, reason = "User with given email already exists!")
    @TypeChecked
    static class PlayerAlreadyExistsException extends RuntimeException { }
}
