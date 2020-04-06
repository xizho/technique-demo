package com.example.dubbo.consumer.hello;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.Duration;
import java.time.Instant;

public class ConsumerMain {
    public static void main(String[] args) {
        Instant start = Instant.now();


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerAgain.ConsumerAgainConfig.class);
        context.start();

        Instant end = Instant.now();
        System.out.println("容器启动耗时：" + Duration.between(start, end).toMillis() + " ms");

        ConsumerAgain action = (ConsumerAgain) context.getBean("consumerAgain");
        String hello = action.doHello("xizho");
        System.out.println("结果：" + hello);


        end = Instant.now();
        System.out.println("总耗时：" + Duration.between(start, end).toMillis() + " ms");
    }
}
