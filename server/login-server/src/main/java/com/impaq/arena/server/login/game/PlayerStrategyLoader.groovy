package com.impaq.arena.server.login.game

import com.impaq.arena.api.Game
import com.impaq.arena.api.PlayerStrategy
import com.impaq.arena.server.login.player.strategy.PlayerStrategyService
import groovy.util.logging.Log
import org.codehaus.groovy.control.CompilationUnit
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.tools.GroovyClass
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Log
@Component
class PlayerStrategyLoader {

    private final PlayerStrategyService strategyService

    private final CompilerConfiguration configuration = new CompilerConfiguration()

    @Autowired
    PlayerStrategyLoader(PlayerStrategyService strategyService) {
        this.strategyService = strategyService

        this.configuration.setSourceEncoding("UTF-8")
        this.configuration.setTargetBytecode(CompilerConfiguration.JDK7)
    }

    PlayerStrategy loadPlayerStrategy(String userId) {
        com.impaq.arena.server.login.player.strategy.PlayerStrategy playerStrategy = strategyService.findOne(userId)
        return loadStrategy(playerStrategy.className, playerStrategy.javaCode)
    }

    PlayerStrategy loadOpponentStrategy(String mode = "test") {
        // TODO add different strategies
        return new TestStrategy()
    }

    PlayerStrategy loadStrategy(String className, String code) {
        CompilationUnit unit = new CompilationUnit(configuration);
        unit.addSource(new SourceUnit(className, code, configuration, unit.getClassLoader(), unit.getErrorCollector()));
        unit.compile();

        // FIXME use ClassLoader.getSystemClassLoader() instead !!! and add Game and PlayerStrategy only !!!
        ClassLoader parentClassLoader = getClass().getClassLoader()
        GroovyClassLoader classLoader = new GroovyClassLoader(parentClassLoader, configuration)
        unit.getClasses().each { GroovyClass clazz ->
            classLoader.defineClass(clazz.name, clazz.bytes)
        }

        Class<?> clazz = classLoader.loadClass(className)
        Object strategy = clazz.newInstance()
        return strategy as PlayerStrategy
    }

    static class TestStrategy implements PlayerStrategy {

        private int round

        @Override
        void playRound(Game game) {
            if (round % 2 == 0) {
                game.recruitBuilders()
            } else {
                game.recruitWarriors()
            }
            game.buildMyCastle()
            game.attackEnemyCastle()
            round++
        }
    }
}
