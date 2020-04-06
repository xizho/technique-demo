package com.example.concurrent.lock;

import java.util.Optional;
import java.util.stream.Stream;

public class NotifyTest {

    public static void main(String[] args) {
        NotifyTest test = new NotifyTest();
        Stream.of("T1", "T2", "T3").forEach(name -> {
            new Thread(() -> {
//                NotifyTest test = new NotifyTest();
                try {
                    test.waitTest();
                    Optional.of("业务处理中..").ifPresent(System.out::println);
                    Thread.sleep(6_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    test.notifyTest();
//                    Optional.of(Thread.currentThread().getName() + "：业务处理完成..").ifPresent(System.out::println);
                }
            }, name).start();
        });
    }


    boolean init = false;

    private synchronized void waitTest() throws InterruptedException {
        while (init) {
            Optional.of(Thread.currentThread().getName() + "：当前线程阻塞！").ifPresent(System.out::println);
            wait();
        }

        Optional.of(Thread.currentThread().getName() + "：当前线程被唤醒！").ifPresent(System.out::println);
        init = true;
    }


    private synchronized void notifyTest() {
        notifyAll();
        init = false;
        Optional.of(Thread.currentThread().getName() + "：当前线程业务处理完成..").ifPresent(System.out::println);
        Optional.of("其他所有线程被唤醒！").ifPresent(System.out::println);
    }

}
