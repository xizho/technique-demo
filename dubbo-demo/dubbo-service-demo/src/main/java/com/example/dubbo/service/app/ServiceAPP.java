package com.example.dubbo.service.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ServiceAPP {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext cpxac = new ClassPathXmlApplicationContext("classpath:spring/provider.xml");
        cpxac.start();

        System.out.println("线程将被阻塞。。。");
        // 阻塞当前线程
        System.in.read();
        System.out.println("阻塞释放。。。");
    }
}
