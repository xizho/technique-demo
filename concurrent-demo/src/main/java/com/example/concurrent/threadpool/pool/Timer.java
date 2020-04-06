package com.example.concurrent.threadpool.pool;

import com.example.concurrent.threadpool.pool.sample.ExecutorDemo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Timer {

    @Resource
    ExecutorDemo executorDemo;

    @Scheduled(fixedDelay = 5_000)
    public void test() {
        System.out.println("定时任务开始执行。。。。");

        for (int i = 0; i < 5; i++) {
            executorDemo.executor();
        }
    }

}
