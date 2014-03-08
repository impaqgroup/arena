package com.impaq.arena.server.login.player

import org.springframework.security.crypto.password.PasswordEncoder
import spock.lang.Specification
import com.impaq.arena.server.login.player.PlayerService.PlayerAlreadyExistsException

class PlayerServiceTest extends Specification {

    PlayerRepository repository = Mock()
    PasswordEncoder passwordEncoder = Mock()
    PlayerService service = new PlayerService(repository, passwordEncoder)

    Player player = new Player(email: "test", password: "secret", name: "testName", surname: "testSurname")

    def "Should register new player"() {
        given:
            passwordEncoder.encode("secret") >> "12345"
        when:
            service.create(player)
        then:
            player.password == "12345"
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
            passwordEncoder.encode("pwd") >> "123"
        when:
            service.update(new Player(email: "test", password: "pwd", name: "newName", surname: "newSurname"))
        then:
            player.email == "test"
            player.password == "123"
            player.name == "newName"
            player.surname == "newSurname"
            player.lastUpdated != null
    }

}
