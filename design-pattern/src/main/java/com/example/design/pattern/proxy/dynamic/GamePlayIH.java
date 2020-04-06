package com.example.design.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GamePlayIH implements InvocationHandler {
    Class clazz = null;
    Object object;

    public GamePlayIH(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object o = method.invoke(this.object, args);
        if (method.getName().equalsIgnoreCase("login")) {
            System.out.println("有人在的登陆我的账号！！");
        }
        return o;
    }
}
