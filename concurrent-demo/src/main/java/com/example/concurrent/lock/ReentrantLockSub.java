package com.example.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xizho
 */
public class ReentrantLockSub extends ReentrantLock {

    public ReentrantLockSub() {
    }

    public ReentrantLockSub(boolean fair) {
        super(fair);
    }

    public String printQueueThreads() {
        StringBuilder sb = new StringBuilder();
        getQueuedThreads().forEach(thread -> sb.append(thread.getName()).append(" <-||-> "));

        return sb.toString();
    }

    public static void main(String[] args) {
//        ReentrantLockSub demo = new ReentrantLockSub();
        new Thread(() -> {
            for (int i = 0; i < 4; i++)
                new Thread(() -> lock.demo(), "Test1_" + i).start();
        }, "other_thread_1").start();

        while (true) {
            if (lock.getQueuedThreads().size() <= 0) continue;

            System.out.println("当前阻塞线程：" + lock.printQueueThreads());
        }
    }

    int x = 0;
    static ReentrantLockSub lock = new ReentrantLockSub();

    void demo() {
        lock.lock();
        try {
            x++;
        } finally {
            lock.unlock();
        }
    }

    int getX() {
        return x;
    }

}
