package com.impaq.arena.server.login.player

import spock.lang.Specification
import com.impaq.arena.server.login.player.PlayerService.PlayerAlreadyExistsException

class PlayerServiceTest extends Specification {

    PlayerRepository repository = Mock()
    PlayerService service = new PlayerService(repository)

    Player player = new Player(email: "test", name: "testName", surname: "testSurname")

    def "Should register new player"() {
        when:
            service.create(player)
        then:
            player.created != null
            player.lastUpdated != null
            1 * repository.save(player)
    }

    def "Should throw when trying to register existing player"() {
        given:
            repository.findOne("test") >> player
        when:
            service.create(player)
        then:
            thrown(PlayerAlreadyExistsException)
    }

    def "Should update existing player"() {
        given:
            repository.findOne("test") >> player
        when:
            service.update(new Player(email: "test", name: "newName", surname: "newSurname"))
        then:
            player.email == "test"
            player.name == "newName"
            player.surname == "newSurname"
    }

}
