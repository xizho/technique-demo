package com.example.dubbo.consumer.hello;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.example.dubbo.provider.api.DemoAgainService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class ConsumerAgain {
    @Reference
    private DemoAgainService demoAgainService;

    public String doHello(String name) {
        return demoAgainService.hello(name);
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.example.dubbo.consumer.hello")
    @ComponentScan("com.example.dubbo.consumer.hello")
    @PropertySource("classpath:/spring/consumer.properties")
    static public class ConsumerAgainConfig {}
}
