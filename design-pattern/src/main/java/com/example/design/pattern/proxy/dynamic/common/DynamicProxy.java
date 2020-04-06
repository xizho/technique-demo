package com.example.design.pattern.proxy.dynamic.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxy<T> {

    public static <T> T newProxyInstance(ClassLoader classLoader, Class<?>[] interfaces, InvocationHandler invocationHandler) {
        new BeforeAdvice().exec();

        return (T) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }

    public static <T> T newProxyInstance(Subject subject) {
        return (T) newProxyInstance(
                subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(),
                new MyInvocationHandler(subject)
        );
    }

}
