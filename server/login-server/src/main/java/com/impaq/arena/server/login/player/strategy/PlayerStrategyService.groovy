package com.impaq.arena.server.login.player.strategy

import org.hibernate.validator.constraints.NotEmpty
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.annotation.Validated

import javax.validation.Valid

import static org.joda.time.DateTime.now
import static org.springframework.transaction.annotation.Propagation.SUPPORTS

@Service
@Validated
@Transactional
class PlayerStrategyService {

    private PlayerStrategyRepository repository

    protected PlayerStrategyService() { }

    @Autowired
    PlayerStrategyService(PlayerStrategyRepository repository) {
        this.repository = repository
    }

    @Transactional(propagation = SUPPORTS, readOnly = true)
    PlayerStrategy findOne(@NotEmpty String playerId) {
        return repository.findOne(playerId)
    }

    void createOrUpdate(@Valid PlayerStrategy strategy) {
        strategy.lastUpdated = now()
        repository.save(strategy)
    }
}
