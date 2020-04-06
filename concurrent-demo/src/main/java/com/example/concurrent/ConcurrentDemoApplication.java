package com.example.concurrent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ConcurrentDemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(ConcurrentDemoApplication.class, args);

    }
}
