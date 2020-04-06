package com.example.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.example.dubbo.provider.api.DemoAgainService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Service
public class DemoAgainServiceImpl implements DemoAgainService {
    @Override
    public String hello(String name) {
        return "Hello " + name + " again.";
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.example.dubbo.service.impl")
    @PropertySource("classpath:/spring/provider.properties")
    static public class ProviderAgainConfig{}
}
