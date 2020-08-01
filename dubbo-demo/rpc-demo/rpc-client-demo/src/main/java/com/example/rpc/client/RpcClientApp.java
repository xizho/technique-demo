package com.example.rpc.client;

import com.example.rpc.server.api.IHelloService;

public class RpcClientApp {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        RpcProxyClient<IHelloService> rpcProxyClient = new RpcProxyClient<>();
        IHelloService helloService = rpcProxyClient.clientProxy(
                IHelloService.class,
                "localhost",
                8080
        );

        String result = helloService.sayHello("xizho");
        System.out.println(result);
    }

}
