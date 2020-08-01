package com.example.pool.thread.execute;

import com.example.pool.thread.MyThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolTest implements Runnable {
    public static void main(String[] args) {
        int coreSize = Runtime.getRuntime().availableProcessors();
        int maxSize = coreSize << 1;
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(20);
        MyThreadPool threadPool = new MyThreadPool(coreSize, maxSize, 60, TimeUnit.SECONDS, blockingQueue, "myTestThreadPool");
        for (int i = 1; i <= 25; i++) {
            threadPool.execute(new MyThreadPoolTest());
            System.out.println();
        }

        /**
         * 动态修改线程池参数
         */
        while (true) {
            if (threadPool.getCompletedTaskCount() >= 10) {
                System.out.println("completed task count :" + threadPool.getCompletedTaskCount());
                threadPool.setCorePoolSize(maxSize);
                
                System.out.println("core pool size :" + threadPool.getCorePoolSize());

                break;
            }

        }

        if (!threadPool.isShutdown())
            threadPool.shutdown();
    }

    @Override
    public void run() {
//        System.out.println("mock business");
        try {
            TimeUnit.SECONDS.sleep(5L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
