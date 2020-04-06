package com.example.other.test.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadWaitTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        createLockThread(new Object());
    }

    public static void createBusyThread() {
        Thread thread = new Thread(() -> {
            while (true) {
                ;
            }
        }, "Busy-Thread");
        thread.start();
    }


    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "Lock-Thread");
        thread.start();
    }
}
