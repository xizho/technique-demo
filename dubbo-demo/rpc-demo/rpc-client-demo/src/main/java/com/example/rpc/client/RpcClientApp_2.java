package com.example.rpc.client;

import com.example.rpc.server.api.IHelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;

public class RpcClientApp_2 {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        RpcProxyClient<IHelloService> proxyClient = context.getBean(RpcProxyClient.class);

        IHelloService helloService = proxyClient.clientProxy(
                IHelloService.class,
                "localhost",
                8080
        );

        String result = helloService.sayHello("xizho");
        System.out.println(result);
    }

}
