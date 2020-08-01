package com.example.rpc.server.provider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.rpc.server.provider")
public class SpringConfig {

    @Bean(name = "rpcServer")
    public RpcServerForContainer getRpcServer() {
        return new RpcServerForContainer(8080);
    }

}
