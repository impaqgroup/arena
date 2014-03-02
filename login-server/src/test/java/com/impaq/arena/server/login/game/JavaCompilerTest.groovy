package com.impaq.arena.server.login.game

import spock.lang.Ignore
import spock.lang.Specification

@Ignore
class JavaCompilerTest extends Specification {

    def "Should compile strategy class source"() {
        given:
            JavaCompiler compiler = new JavaCompiler()
            InputStream strategyCode = getClass().getClassLoader().getResourceAsStream("ExampleStrategy.java")
        when:
            Class clazz = compiler.compile("ExampleStrategy", strategyCode.getText())
        then:
            clazz.getName() == "ExampleStrategy"
            clazz.getMethods()[0].getName() == "playRound"
    }
}
