package com.example.rpc.server.provider;

import com.example.rpc.server.api.IHelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class RpcServerProviderApp {

    public static void main(String[] args) {
        IHelloService helloService = new HelloServiceImpl();
        RpcProxyServer proxyServer = new RpcProxyServer();
        System.out.println("提供服务。。。");
        proxyServer.publisher(helloService, 8080);
    }

}
