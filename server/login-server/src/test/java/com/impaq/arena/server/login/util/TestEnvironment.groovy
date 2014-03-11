package com.impaq.arena.server.login.util

import org.springframework.core.env.StandardEnvironment
import org.springframework.core.io.support.ResourcePropertySource

class TestEnvironment extends StandardEnvironment {

    TestEnvironment() {
        super()
        getPropertySources().addLast(new ResourcePropertySource("classpath:application.properties"))
        getPropertySources().addLast(new ResourcePropertySource("classpath:config/application.properties"))
    }
}
