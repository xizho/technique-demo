package com.example.dubbo.service.app;

import com.example.dubbo.service.impl.DemoAgainServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class ServiceAgain {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoAgainServiceImpl.ProviderAgainConfig.class);
        context.start();

        System.out.println("线程将被阻塞。。。");
        // 阻塞当前线程
        System.in.read();
        System.out.println("阻塞释放。。。");
    }
}
