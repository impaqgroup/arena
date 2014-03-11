package com.impaq.arena.server.login

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
@RequestMapping("/")
class HomeController {

    @Value('${app.version:UNKNOWN}')
    String version

    @RequestMapping(method = GET)
    def home() {
        return [
            greeting: "Welcome to Impaq Arena! See the list of available resources below and have fun!",
            resources: [[
                    path: "/",
                    desc: "Represents this very page.",
                    operations: [[
                        method: "GET",
                        desc: "Gets this documentation page. This operation does not require authentication. All other " +
                            "resources require HTTP Basic authentication, unless otherwise noted. To create an account " +
                            "that allows usage od authenticated endpoints, see POST /player operation below.",
                        auth: "none"
                    ]]
                ],[
                    path: "/repository",
                    desc: "Contains Maven repository with artifacts to implement Your strategy for the game. All artifacts " +
                        "include sources, so be sure to check them out for more documentation!",
                    notice: "If you get `peer not authenticated` error, than see here http://bit.ly/1k7dx2f - " +
                        "we're working on it!",
                    operations: [[
                        method: "GET",
                        desc: "Well, it's a Maven repo, so GET all you need, cause GET is all you get ;)",
                        auth: "none"
                    ]],
                    artifacts: [[
                        groupId: "com.impaq.arena",
                        artifactId: "player-api",
                        version: version,
                        type: ["pom", "jar", "test-jar"],
                        desc: "The player API to implement. Check out JavaDoc in sources for API description."
                    ],[
                        groupId: "com.impaq.arena",
                        artifactId: "game-engine",
                        version: version,
                        type: ["pom", "jar"],
                        desc: "Basic game engine to help test your strategy."
                    ]]
                ],[
                    path: "/player",
                    desc: "Manipulates players information.",
                    operations: [[
                        method: "GET",
                        desc: "View your current profile."
                    ],[
                        method: "POST",
                        desc: "Register/create new profile.",
                        auth: "none",
                        struct: [
                            email: "Your email and player ID",
                            password: "Your password",
                            name: "Your name",
                            surname: "Your surname",
                            term: "Your university term"
                        ]
                    ],[
                        method: "PUT",
                        desc: "Update your profile.",
                        struct: [
                            password: "Your password",
                            name: "Your name",
                            surname: "Your surname",
                            term: "Your university term"
                        ]
                    ]]
                ],[
                    path: "/player/strategy",
                    desc: "Manipulates players strategy for the game. A strategy is a piece of code written in Java " +
                        "that contains implementation of 'com.impaq.arena.api.PlayerStrategy' interface that is used " +
                        "to act on behalf of the player in the game.",
                    operations: [[
                        method: "GET",
                        desc: "View your current strategy"
                    ],[
                        method: "PUT",
                        desc: "Upload a new version of your strategy.",
                        struct: [
                            className: "The name of the class implementing 'com.impaq.arena.api.PlayerStrategy' to be used in the game",
                            javaCode: "The Java code that contains the implementation of player strategy. The contents of this " +
                                "field have to obey the same rules as the contents of a single .java source file. The implementation " +
                                "of player strategy should be the only public class declared in this code. A possibility to " +
                                "implements strategies in other, JVM compliant languages are considered in the future."
                        ]
                    ]]
                ],[
                    path: "/game",
                    desc: "Starts the game using your strategy.",
                    operations: [[
                        method: "POST",
                        desc: "Schedules a new game to be played.",
                        struct: [
                            mode: "Selects the game mode. Use 'test' (default) to run a game against a test strategy. " +
                                "Use 'random' to run a game against a random opponent taken from amongst other " +
                                "registered players with working strategies."
                        ]
                    ]]
                ],[
                    path: "/game/log",
                    desc: "Hold the log of the last game you played. Remember to check this out after each game to see if you won!",
                    operations: [[
                        method: "GET",
                        desc: "Retrieve the log of last game you played."
                    ]]
                ]],
            legal: "By using this site I agree to the processing of my personal data by IMPAQ sp. z o.o. and " +
                "ITSkills sp. z o.o. for the recruitment process and other recruitment processes carried out " +
                "in the future by the above-mentioned companies. At the same time, I declare that I have been " +
                "informed that: the Administrator of my personal data is IMPAQ sp. z o.o. and ITSkills sp. z o.o.; " +
                "My data will not be disclosed to other entities for recruitment purposes, I have a right to access, " +
                "correct and request removal of my personal data."
        ]
    }

}
