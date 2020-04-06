package com.example.concurrent.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 使用notify/wait时，wait会释放锁，notify不会，所以只有在notify所在方法执行结束后，才会执行wait所在方法
 */
public class MyContainer {

    volatile List<Object> objects = new ArrayList<>();

    public void add(Object o) {
        objects.add(o);
    }

    public int size() {
        return objects.size();
    }

    public static void main(String[] args) {
        final Object lock = new Object();
        MyContainer myContainer = new MyContainer();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2 start");
                if (myContainer.size() <= 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("t2 end");
            }
        }, "t2").start();


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t1 start");
                for (int i = 0; i < 10; i++) {
                    myContainer.add(new Object());
                    System.out.println("t1 " + myContainer.size());

                    if (myContainer.size() == 5) {
                        lock.notify();
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t1 end");
            }
        }, "t1").start();
    }
}
