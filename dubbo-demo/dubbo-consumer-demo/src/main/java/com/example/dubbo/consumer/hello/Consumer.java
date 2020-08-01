package com.example.dubbo.consumer.hello;

import com.example.dubbo.provider.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.Duration;
import java.time.Instant;

public class Consumer {
    public static void main(String[] args) {
        Instant start = Instant.now();


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/consumer.xml");
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService");
        String hello = demoService.hello("xizho");
        System.out.println("结果：" + hello);


        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + " ms");

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
