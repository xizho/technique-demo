package com.example.concurrent.container.cyclicbarrier;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RunByGroup {

    public static void main(String[] args) {
        int currency = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(currency);
       /* ExecutorService executorService = Executors.newFixedThreadPool(currency, new ThreadFactory() {
            AtomicInteger counter = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {

                return new Thread(r,"RunByGroup-" + counter.getAndIncrement());
            }
        });
        for (int i = 1, groups = 100 / currency; i <= groups; i++) {
            System.out.printf("第%d组开始执行。。。", i);
            System.out.println();
            for (int j = 0; j < currency; j++) {
                executorService.execute(new Task(cyclicBarrier));
            }
            System.out.printf("第%d组结束执行。。。", i);
            System.out.println();
        }

        executorService.shutdown();
        while (!executorService.isShutdown()) ;

*/
        for (int i = 0; i < 100; i++) {
            new Task(cyclicBarrier).start();
        }
    }

    static class Task extends Thread {

        private CyclicBarrier cyclicBarrier;


        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(currentThread().getName() + "：开始执行。。。");

                TimeUnit.SECONDS.sleep(7L);
                cyclicBarrier.await();
                System.out.println(currentThread().getName() + "：结束执行。");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
