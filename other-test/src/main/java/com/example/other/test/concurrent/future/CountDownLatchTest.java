package com.example.other.test.concurrent.future;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);

        for (int i = 0; i < 4; i++) {
            Task task = new Task(latch);
            Thread t = new Thread(task);
            t.start();
        }
        latch.await();
        System.out.println("任务完成。。。");
    }

    public static class Task implements Runnable {
        private final CountDownLatch latch;

        public Task(CountDownLatch latch) {
            this.latch = latch;
        }


        @Override
        public void run() {
            try {
                System.out.println("任务处理中。。。");
                TimeUnit.SECONDS.sleep(4);
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
