package com.example.concurrent.lock;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;

public class CountDownLatchTest {

    static CountDownLatch c = new CountDownLatch(3);

    static ExecutorService service = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
        Instant start = Instant.now();

        service.execute(() -> {
            operation1();
            c.countDown();
        });
        service.execute(() -> {
            operation2();
            c.countDown();
        });
        service.execute(() -> {
            operation3();
            c.countDown();
        });

        c.await();

        Instant end = Instant.now();

        Duration esp = Duration.between(start, end);
        System.out.println("everything are done");
        System.out.println("耗时：" + esp.toMillis());

        // 线程池使用结束后需要关闭，否则JVM不会退出
        service.shutdown();
    }


    static void operation1() {
        try {
            System.out.println(Thread.currentThread().getName() + " -> operation1 doing");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName() + " -> operation1 done ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void operation2() {
        try {
            System.out.println(Thread.currentThread().getName() + " -> operation2 doing");
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + " -> operation2 done ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void operation3() {
        try {
            System.out.println(Thread.currentThread().getName() + " -> operation3 doing");
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName() + " -> operation3 done ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
