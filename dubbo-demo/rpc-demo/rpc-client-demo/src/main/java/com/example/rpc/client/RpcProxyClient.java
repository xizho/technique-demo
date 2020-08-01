package com.example.rpc.client;

import java.lang.reflect.Proxy;

public class RpcProxyClient<T> {

    public T clientProxy(final Class<?> interfaceClass, final String host, final int port) {
        return (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class[]{interfaceClass},
                new RemoteInvocationHandler(host, port)
        );
    }
}
