package com.impaq.arena.server.login.game

import com.impaq.arena.api.PlayerStrategy
import com.impaq.arena.server.login.player.strategy.PlayerStrategyService
import groovy.util.logging.Log
import org.abstractmeta.toolbox.compilation.compiler.JavaSourceCompiler
import org.abstractmeta.toolbox.compilation.compiler.impl.JavaSourceCompilerImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Component

import static com.impaq.arena.server.login.util.ClassLoaderSwitchingProxy.proxyClassLoader

@Log
@Component
class PlayerStrategyLoader {

    private static final String defaultPlayerApiPath = 'classpath:resources/player-api.jar'

    private final ResourceLoader resourceLoader
    private final Resource playerApi
    private final ClassLoader playerApiClassLoader
    private final PlayerStrategyService strategyService

    @Autowired
    PlayerStrategyLoader(ResourceLoader resourceLoader, PlayerStrategyService strategyService, Environment environment) {
        this(resourceLoader, strategyService, environment.getProperty("player.api.path", defaultPlayerApiPath))
    }

    PlayerStrategyLoader(ResourceLoader resourceLoader, PlayerStrategyService strategyService, String playerApiPath = defaultPlayerApiPath) {
        log.info("Using player API from: ${playerApiPath}")
        this.strategyService = strategyService
        this.resourceLoader = resourceLoader
        this.playerApi = resourceLoader.getResource(playerApiPath)
        this.playerApiClassLoader = new URLClassLoader(playerApi.getURL())
        log.info("Loaded: " + playerApiClassLoader.loadClass("com.impaq.arena.api.PlayerStrategy"))
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
        ClassLoader classLoader = compileStrategySource(className, code)
        Class<?> clazz = classLoader.loadClass(className)
        Object strategy = clazz.newInstance()
        // we need to proxy, because we used different ClassLoader to load the class
        return (PlayerStrategy) proxyClassLoader(getClass().getClassLoader(), strategy, PlayerStrategy)
    }

    ClassLoader compileStrategySource(String className, String code) {
        JavaSourceCompiler compiler = new JavaSourceCompilerImpl();
        JavaSourceCompiler.CompilationUnit unit = compiler.createCompilationUnit();
        unit.addClassPathEntry(playerApi.getFile().getAbsolutePath())
        unit.addJavaSource(className, code)
        return compiler.compile(playerApiClassLoader, unit);
    }

    static class TestStrategy implements PlayerStrategy {

        private int round

        @Override
        void playRound(com.impaq.arena.api.Game game) {
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
