package com.example.concurrent.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 当notify(1)执行后，继续执行wait(2)，会释放锁，然后执行wait(1)，当执行结束后再执行notify(2)，现在会执行wait(2)后的方法
 */
public class MyContainer2 {

    volatile List<Object> objects = new ArrayList<>();

    public void add(Object o) {
        objects.add(o);
    }

    public int size() {
        return objects.size();
    }

    public static void main(String[] args) {
        final Object lock = new Object();
        MyContainer2 myContainer = new MyContainer2();
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
                lock.notify();
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

                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
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
