package com.impaq.arena.server.login

import groovy.json.JsonBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup

@WebAppConfiguration
@ContextConfiguration(classes = LoginServer, loader = SpringApplicationContextLoader)
class IntegrationTest extends Specification {

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    def setup() {
        mockMvc = webAppContextSetup(this.wac).build();
    }

    def "Should require email" () {
        given:
            String content = new JsonBuilder([
                email: "test@test.pl", password: "test", name: "testName", surname: "testSurname"
            ]).toString()
        when:
            def response = mockMvc
                .perform(post("/player")
                .contentType(APPLICATION_JSON)
                .content(content)
            ).andDo(print());
        then:
            response.andExpect(status().isUnprocessableEntity())
    }
}
