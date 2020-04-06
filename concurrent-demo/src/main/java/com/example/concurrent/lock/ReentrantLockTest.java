package com.example.concurrent.lock;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) {
        ReentrantLockTest rtl = new ReentrantLockTest();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    rtl.put(j);
                }
            }, "plus_" + i).start();
        }

    }


    // 无参默认非公平锁
    private ReentrantLock unfairLock = new ReentrantLock();

    // 构造器传true，创建公平锁
    private ReentrantLock fairLock = new ReentrantLock(true);

    private volatile int i = 0;

    private void put(int i) {
        try {
            unfairLock.lock();
            this.i = i++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            unfairLock.unlock();
        }
    }

    private int get() {
        try {
            unfairLock.lock();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            unfairLock.unlock();
        }

        return -1;
    }

    public void test() {
        unfairLock.tryLock();
    }

}
