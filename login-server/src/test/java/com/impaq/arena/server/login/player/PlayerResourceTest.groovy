package com.impaq.arena.server.login.user

import com.impaq.arena.server.login.IntegrationTestCase
import org.springframework.beans.factory.annotation.Autowired

class PlayerResourceTest extends IntegrationTestCase {

    @Autowired
    UserResource resource;

    def "should run" () {
        when:
            resource.register(null);
        then:
            true
    }

}
