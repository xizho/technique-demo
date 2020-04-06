package com.example.concurrent.atomic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AtomicIntegerTest {

    public static void main(String[] args) throws InterruptedException {
        generalInt();
    }

    private static volatile int value = 0;

    private static Set<Integer> countSet = Collections.synchronizedSet(new HashSet<>());

    static void generalInt() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            int x = 0;
            while (x < 500) {
                int temp = value;
                System.out.println(Thread.currentThread().getName() + ":" + temp);
                value++;
                x++;
                countSet.add(value);
            }
        });

        Thread t2 = new Thread(() -> {
            int x = 0;
            while (x < 500) {
                int temp = value;
                System.out.println(Thread.currentThread().getName() + ":" + temp);
                value++;
                x++;
                countSet.add(value);
            }
        });

        Thread t3 = new Thread(() -> {
            int x = 0;
            while (x < 500) {
                int temp = value;
                System.out.println(Thread.currentThread().getName() + ":" + temp);
                value++;
                x++;
                countSet.add(value);
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("***********************");
        System.out.println(countSet.size());
    }

}
