package com.example.concurrent.container.cyclicbarrier;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.currentThread;

public class BankWaterService implements Runnable {

    CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this);
    ExecutorService executor = Executors.newFixedThreadPool(4);

    ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                try {
                    sheetBankWaterCount.put(currentThread().getName(), 1);
                    System.out.println(currentThread().getName() + "：开始。。");
                    cyclicBarrier.await();
                    System.out.println(currentThread().getName() + "：完成。。");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }

    @Override
    public void run() {
        AtomicInteger count = new AtomicInteger();
        sheetBankWaterCount.forEach((k, v) -> count.addAndGet(v));
        sheetBankWaterCount.put("result", count.intValue());
        System.out.println("result: " + count);
    }

    public static void main(String[] args) {
        new BankWaterService().count();
    }
}
