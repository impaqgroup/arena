package com.impaq.arena.server.login.player

import com.impaq.arena.server.login.IntegrationTestCase
import org.springframework.beans.factory.annotation.Autowired

class PlayerResourceTest extends IntegrationTestCase {

    @Autowired
    PlayerResource resource;

    def "should run" () {
        when:
            resource.register(null);
        then:
            true
    }

}
