package com.impaq.arena.server.login.game

import org.abstractmeta.toolbox.compilation.compiler.JavaSourceCompiler
import org.abstractmeta.toolbox.compilation.compiler.impl.JavaSourceCompilerImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader

class JavaCompiler {

    private final ResourceLoader resourceLoader

    private final Resource playerApi

    private final ClassLoader playerApiClassLoader

    @Autowired
    JavaCompiler(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader
        this.playerApi = resourceLoader.getResource("classpath:resources/player-api.jar")
        this.playerApiClassLoader = new URLClassLoader(playerApi.getURL())
    }

    Class compile(String className, String code) {
        JavaSourceCompiler compiler = new JavaSourceCompilerImpl();
        JavaSourceCompiler.CompilationUnit unit = compiler.createCompilationUnit();

        unit.addJavaSource(className, code)

        ClassLoader classLoader = compiler.compile(playerApiClassLoader, unit);
        return classLoader.loadClass(className);
    }
}
