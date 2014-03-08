package com.impaq.arena.server.login.user

import com.impaq.arena.server.login.player.Player
import com.impaq.arena.server.login.player.PlayerRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UsernameNotFoundException
import spock.lang.Specification

class UserServiceTest extends Specification {

    PlayerRepository repository = Mock()
    List<String> admins = []
    UserService service = new UserService(repository, admins)

    def "If user does not exist, then throw UsernameNotFoundException" () {
        when:
            service.loadUserByUsername("test")
        then:
            thrown(UsernameNotFoundException)
    }

    def "If regular user, then should have ROLE_USER"() {
        given:
            repository.findOne("test") >> new Player(email: "test")
        when:
            User user = service.loadUserByUsername("test")
        then:
            !user.isAdmin()
            user.getAuthorities() == [new SimpleGrantedAuthority("ROLE_USER")]
    }

    def "If admin, then should have ROLE_ADMIN"() {
        given:
            repository.findOne("test") >> new Player(email: "test")
            admins.add("test")
        when:
            User user = service.loadUserByUsername("test")
        then:
            user.isAdmin()
            user.getAuthorities() == [new SimpleGrantedAuthority("ROLE_ADMIN")]
    }
}
