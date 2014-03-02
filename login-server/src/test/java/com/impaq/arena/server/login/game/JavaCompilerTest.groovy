package com.impaq.arena.server.login.game

import org.springframework.core.io.DefaultResourceLoader
import org.springframework.core.io.ResourceLoader
import spock.lang.Specification

class JavaCompilerTest extends Specification {

    ResourceLoader resourceLoader = new DefaultResourceLoader()

    def "Should compile strategy class source"() {
        given:
            JavaCompiler compiler = new JavaCompiler(resourceLoader)
            InputStream strategyCode = resourceLoader.getResource("classpath:ExampleStrategy.java").getInputStream()
        when:
            Class clazz = compiler.compile("ExampleStrategy", strategyCode.getText())
        then:
            clazz.getName() == "ExampleStrategy"
            clazz.getMethods()[0].getName() == "playRound"
    }
}
