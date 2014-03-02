package com.impaq.arena.server.login.game

import org.abstractmeta.toolbox.compilation.compiler.JavaSourceCompiler
import org.abstractmeta.toolbox.compilation.compiler.impl.JavaSourceCompilerImpl

class JavaCompiler {

    Class compile(String className, String code) {
        JavaSourceCompiler compiler = new JavaSourceCompilerImpl();
        JavaSourceCompiler.CompilationUnit unit = compiler.createCompilationUnit();

        unit.addJavaSource(className, code)

        ClassLoader classLoader = compiler.compile(getClass().getClassLoader(), unit);
        return classLoader.loadClass(className);
    }
}
