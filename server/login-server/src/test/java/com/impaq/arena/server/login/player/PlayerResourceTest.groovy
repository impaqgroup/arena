package com.impaq.arena.server.login.player

import groovy.json.JsonBuilder
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class PlayerResourceTest extends Specification {

    PlayerService service = Mock()

    PlayerResource resource = new PlayerResource(service)

    MockMvc mockMvc = standaloneSetup(resource).build();

    String content = new JsonBuilder([
        email: "test@test.pl", password: "test", name: "testName", surname: "testSurname"
    ]).toString()

    def "Should require email" () {
        when:
            def response = mockMvc
                .perform(post("/player")
                    .contentType(APPLICATION_JSON)
                    .content(content)
                ).andDo(print());
        then:
            response.andExpect(status().isCreated())
            1 * service.create({ Player p ->
                p.email == "test@test.pl" &&
                p.password == "test" &&
                p.name == "testName" &&
                p.surname == "testSurname"
            })
    }

}
