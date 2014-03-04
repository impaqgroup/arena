package com.impaq.arena.server.login.game

import com.impaq.arena.api.PlayerStrategy
import com.impaq.arena.server.login.player.strategy.PlayerStrategyService
import groovy.util.logging.Log
import org.abstractmeta.toolbox.compilation.compiler.JavaSourceCompiler
import org.abstractmeta.toolbox.compilation.compiler.impl.JavaSourceCompilerImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.env.Environment
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Component

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

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
    }

    PlayerStrategy loadPlayerStrategy(String userId) {
        com.impaq.arena.server.login.player.strategy.PlayerStrategy playerStrategy = strategyService.findOne(userId)
        return loadStrategy(playerStrategy.className, playerStrategy.javaCode)
    }

    PlayerStrategy loadOpponentStrategy(String mode = test) {
        return new TestStrategy()
    }

    PlayerStrategy loadStrategy(String className, String code) {
        ClassLoader classLoader = compileStrategySource(className, code)
        Class<?> clazz = classLoader.loadClass(className)
        Object strategy = clazz.newInstance()
        return proxy(strategy) // we need to proxy, because we used different ClassLoader to load the class
    }

    ClassLoader compileStrategySource(String className, String code) {
        JavaSourceCompiler compiler = new JavaSourceCompilerImpl();
        JavaSourceCompiler.CompilationUnit unit = compiler.createCompilationUnit();
        unit.addJavaSource(className, code)
        return compiler.compile(playerApiClassLoader, unit);
    }

    PlayerStrategy proxy(Object target) {
        ClassLoader classLoader = getClass().getClassLoader()
        Class<?>[] interfaces = [PlayerStrategy]
        InvocationHandler handler = new PlayerStrategyInvocationHandler(target)
        return (PlayerStrategy) java.lang.reflect.Proxy.newProxyInstance(classLoader, interfaces, handler)
    }

    static class PlayerStrategyInvocationHandler implements InvocationHandler {

        private final Object target
        private final Class<?> targetClass

        PlayerStrategyInvocationHandler(Object target) {
            this.target = target
            this.targetClass = target.getClass()
        }

        @Override
        Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            log.info("Calling method ${method.getName()}...")
            Method targetMethod = targetClass.getDeclaredMethod(method.getName(), method.getParameterTypes())
            return targetMethod.invoke(target, args)
        }
    }

    static class TestStrategy implements PlayerStrategy {

        private int round

        @Override
        void playRound(com.impaq.arena.api.Game game) {
            log.info("Playing test round $round...")
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
