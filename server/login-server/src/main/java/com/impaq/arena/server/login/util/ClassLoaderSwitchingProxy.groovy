package com.impaq.arena.server.login.util

import groovy.util.logging.Log

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

@Log
class ClassLoaderSwitchingProxy implements InvocationHandler {

    static Object proxyClassLoader(ClassLoader classLoader, Object target, Class<?>...interfaces) {
        InvocationHandler handler = new ClassLoaderSwitchingProxy(target)
        return java.lang.reflect.Proxy.newProxyInstance(classLoader, interfaces, handler)
    }

    private final Object target
    private final Class<?> targetClass
    private final ClassLoader targetClassLoader

    private ClassLoaderSwitchingProxy(Object target) {
        this.target = target
        this.targetClass = target.getClass()
        this.targetClassLoader = targetClass.getClassLoader()
    }

    @Override
    Object invoke(Object obj, Method method, Object[] origArgs) throws Throwable {
        try {
            Class<?>[] proxyArgTypes = doProxyArgTypes(method)
            Object[] proxyArgs = doProxyArgs(origArgs, proxyArgTypes)
            return doInvoke(method, proxyArgs, proxyArgTypes)
        } catch (Throwable e) {
            log.log(java.util.logging.Level.SEVERE, "Proxied call failed!", e)
            throw new RuntimeException("Proxied call failed!", e)
        }
    }

    private Class<?>[] doProxyArgTypes(Method method) {
        Class<?>[] origArgTypes = method.getParameterTypes()
        return origArgTypes.collect { Class<?> origArgType ->
            targetClassLoader.loadClass(origArgType.getName())
        }
    }

    private Object[] doProxyArgs(Object[] origArgs, Class<?>[] proxyArgTypes) {
        if (origArgs == null) {
            return null
        }
        Object[] proxyArgs = new Object[origArgs.length]
        origArgs.eachWithIndex { Object origArg, int i ->
            if (origArg == null) {
                proxyArgs[i] = null
            } else {
                proxyArgs[i] = proxyClassLoader(targetClassLoader, origArg, proxyArgTypes[i])
            }
        }
        return proxyArgs
    }

    private Object doInvoke(Method method, Object[] proxyArgs, Class<?>[] proxyArgTypes) {
        Method targetMethod = targetClass.getDeclaredMethod(method.getName(), proxyArgTypes)
        if (proxyArgs == null || proxyArgs.length == 0) {
            log.info("Will proxy ${targetMethod.getName()} on ${target}!")
            return targetMethod.invoke(target)
        } else {
            log.info("Will proxy ${targetMethod.getName()} on ${target}!")
            return targetMethod.invoke(target, proxyArgs)
        }
    }
}
