package com.example.concurrent.container.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int currency = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(currency, () -> System.out.println(Thread.currentThread().getName() + "：完成。。"));
        for (int i = 0; i < currency; i++) {
            new Task(cyclicBarrier).start();
        }
    }

    private static class Task extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1L);
                System.out.println(Thread.currentThread().getName() + ": 到达第一个栅栏。。。");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + ": 冲破第一个栅栏，到达第二个栅栏。。。");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + ": 再一次冲破栅栏。。。");
            } catch (Exception e) {
                e.printStackTrace();
            }
            super.run();
        }
    }
}
