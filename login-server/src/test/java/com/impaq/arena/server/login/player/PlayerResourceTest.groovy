package com.impaq.arena.server.login.player

import com.impaq.arena.server.login.IntegrationTestCase
import groovy.json.JsonBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.context.WebApplicationContext

import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup

class PlayerResourceTest extends IntegrationTestCase {

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    def setup() {
        mockMvc = webAppContextSetup(this.wac).build();
    }

    def "Should require email" () {
        given:
            def content = new JsonBuilder(new Player(email: "test")).toPrettyString()
            println(content)
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
