package com.impaq.arena.server.login.game

import com.impaq.arena.api.PlayerStrategy
import org.abstractmeta.toolbox.compilation.compiler.JavaSourceCompiler
import org.abstractmeta.toolbox.compilation.compiler.impl.JavaSourceCompilerImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

class PlayerStrategyLoader {

    private final ResourceLoader resourceLoader

    private final Resource playerApi

    private final ClassLoader playerApiClassLoader

    @Autowired
    PlayerStrategyLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader
        this.playerApi = resourceLoader.getResource("classpath:resources/player-api.jar")
        this.playerApiClassLoader = new URLClassLoader(playerApi.getURL())
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
            Method targetMethod = targetClass.getDeclaredMethod(method.getName(), method.getParameterTypes())
            return targetMethod.invoke(target, args)
        }
    }
}
