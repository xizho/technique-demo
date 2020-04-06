package com.example.concurrent.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 使用CountDownLatch实现
 */
public class MyContainer3 {

    volatile List<Object> objects = new ArrayList<>();

    public void add(Object o) {
        objects.add(o);
    }

    public int size() {
        return objects.size();
    }

    public static void main(String[] args) {
        CountDownLatch c = new CountDownLatch(1);
        MyContainer3 myContainer = new MyContainer3();
        new Thread(() -> {
            System.out.println("t2 start");
            if (myContainer.size() <= 5) {
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("t2 end");
        }, "t2").start();


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("t1 start");
            for (int i = 0; i < 10; i++) {
                myContainer.add(new Object());
                System.out.println("t1 " + myContainer.size());

                if (myContainer.size() == 5) {
                    c.countDown();
                }

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1 end");
        }, "t1").start();
    }
}
