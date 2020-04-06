package com.example.design.pattern.singleton.singletons.lazy;

import com.example.design.pattern.singleton.singletons.ExecutorThread;

public class LazySingletonTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(new ExecutorThread());
        Thread t2 = new Thread(new ExecutorThread());

        t1.start();
        t2.start();

        System.out.println("End..");
    }

}
