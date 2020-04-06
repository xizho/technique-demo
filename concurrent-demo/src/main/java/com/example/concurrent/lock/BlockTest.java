package com.example.concurrent.lock;

import java.util.Optional;
import java.util.stream.Stream;

public class BlockTest {

    public static void main(String[] args) throws InterruptedException {
        final BooleanLock booleanLock = new BooleanLock();

        Stream.of("T1", "T2", "T3", "T4", "T5").forEach(name -> {
            new Thread(() -> {
                try {
                    booleanLock.lock();
                    Optional.of("当前阻塞线程数量为：" + booleanLock.getBlockedSize()).ifPresent(System.out::println);
                    Optional.of(Thread.currentThread().getName() + " have the lock monitor .")
                            .ifPresent(System.out::println);
                    work();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                /*} catch (Lock.TimeOutException e) {
                    Optional.of(Thread.currentThread().getName() + e.getMessage())
                            .ifPresent(System.out::println);*/
                } finally {
                    try {
                        booleanLock.unlock();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, name).start();
        });

//        Thread.sleep(100);
//        booleanLock.unlock();
    }

    private static void work() throws InterruptedException {
        Optional.of(Thread.currentThread().getName() + " is working...")
                .ifPresent(System.out::println);
        Thread.sleep(05_000);
    }
}
