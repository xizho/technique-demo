package com.example.rpc.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean(name = "rpcClient")
    public RpcProxyClient getProxyClient(){
        return new RpcProxyClient();
    }
}
