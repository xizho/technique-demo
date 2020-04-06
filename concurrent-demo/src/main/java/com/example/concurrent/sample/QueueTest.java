package com.example.concurrent.sample;

import java.time.Instant;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class QueueTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("---------------优先级队列------------------");
        // 优先级队列
        PriorityQueue<String> sq = new PriorityQueue<>(Comparator.comparingInt(Integer::parseInt));
        sq.offer("6");
        sq.offer("1");
        sq.offer("2");
        sq.offer("5");
        sq.offer("3");
        sq.offer("4");
        sq.offer("0");

        for (int i = 0, size = sq.size(); i < size; i++) {
            System.out.println(sq.poll());
        }

        System.out.println("---------------延迟队列------------------");
        // 延迟队列
        DelayQueue<DelayedSelf> dq = new DelayQueue<>();
        dq.offer(new DelayedSelf("t1", 7000));
        dq.offer(new DelayedSelf("t2", 2000));
        dq.offer(new DelayedSelf("t3", 9000));
        dq.offer(new DelayedSelf("t4", 3000));
        dq.offer(new DelayedSelf("t5", 1000));
        dq.offer(new DelayedSelf("t6", 60000));

        while (true) {
            DelayedSelf take = dq.take();
            System.out.println(take);

            if (dq.isEmpty()) break;
        }

        System.out.println("---------------------------------");
    }


    /**
     * 延迟队列
     */
    static class DelayedSelf implements Delayed {

        String name;
        long time;
        long start = Instant.now().toEpochMilli();

        public DelayedSelf(long time) {
            this.time = time;
        }

        public DelayedSelf(String name, long time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert((time + start) - Instant.now().toEpochMilli(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString() {
            return "DelayedSelf{" +
                    "name='" + name + '\'' +
                    ", time=" + time +
                    '}';
        }
    }

}
