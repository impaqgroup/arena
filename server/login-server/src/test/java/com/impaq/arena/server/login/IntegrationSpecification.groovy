package com.impaq.arena.server.login

import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification

@WebAppConfiguration
@ContextConfiguration(classes = LoginServer, loader = SpringApplicationContextLoader)
class IntegrationSpecification extends Specification {
}
