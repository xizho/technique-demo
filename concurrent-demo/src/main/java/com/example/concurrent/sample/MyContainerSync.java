package com.example.concurrent.sample;


import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class MyContainerSync<T> {
    final private LinkedList<T> linkedList = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;

    public synchronized void put(T t) {
        try {
            while (linkedList.size() == MAX) {
                this.wait();
            }

            linkedList.add(t);
            ++count;
            this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized T get() {
        T t = null;

        try {
            while (linkedList.size() == 0) {
                this.wait();
            }

            t = linkedList.removeFirst();
            count--;
            this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
        MyContainerSync<String> mcs = new MyContainerSync<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(mcs.get());
                }
            }, "c_" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 20; j++) {
                    mcs.put(Thread.currentThread().getName() + "_" + j);
                }
            }, "p_" + i).start();
        }
    }
}
