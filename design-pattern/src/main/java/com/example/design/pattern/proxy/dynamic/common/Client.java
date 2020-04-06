package com.example.design.pattern.proxy.dynamic.common;

import java.lang.reflect.InvocationHandler;

public class Client {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        InvocationHandler invocationHandler = new MyInvocationHandler(subject);
        Subject subjectProxy = DynamicProxy.newProxyInstance(
                subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(),
                invocationHandler);

        subjectProxy.doSth("Finish..");

        System.out.println("/************************************/");

        Subject subjectProxy2 = DynamicProxy.newProxyInstance(subject);
        subjectProxy2.doSth("Finish2..");
    }
}
