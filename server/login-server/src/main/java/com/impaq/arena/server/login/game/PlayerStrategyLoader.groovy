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

import java.nio.file.Files

import static java.nio.file.Files.createTempDirectory

@Log
@Component
class PlayerStrategyLoader {

    private final PlayerStrategyService strategyService

    @Autowired
    PlayerStrategyLoader(PlayerStrategyService strategyService) {
        this.strategyService = strategyService
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
        CompilerConfiguration configuration = new CompilerConfiguration()
        configuration.setSourceEncoding("UTF-8")
        configuration.setTargetBytecode(CompilerConfiguration.JDK7)
        configuration.setTargetDirectory(createTempDirectory("target").toFile())

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

        @Override
        void playRound(Game game) {
            if (game.spyEnemyBuildersCount() > game.myWizardsStrength() / 2) {
                game.recruitWizards();
                game.recruitWizards();
                game.attackEnemyBuilders();
            } else if (game.spyEnemyWarriorsCount() > game.myWizardsStrength() / 2) {
                game.recruitWizards();
                game.recruitWizards();
                game.attackEnemyWarriors();
            } else {
                game.recruitBuilders();
                game.recruitBuilders();
                game.buildMyCastle();
            }
        }
    }
}
