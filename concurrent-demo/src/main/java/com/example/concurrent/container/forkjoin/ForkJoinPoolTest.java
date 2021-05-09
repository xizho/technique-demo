package com.example.concurrent.container.forkjoin;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest {

    static int[] NUMS = new int[1000_000];
    static int MAX_NUM = 50000;
    static Random r = new Random();

    static {
        for (int i = 0; i < NUMS.length; i++) {
            NUMS[i] = r.nextInt(1000);
        }

        System.out.println("和应为："+Arrays.stream(NUMS).sum());
    }

    static class Task extends RecursiveAction {

        private int start;
        private int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= MAX_NUM) {
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum += NUMS[i];
                }

                System.out.println("from: " + start + " to: " + end + " = " + sum);
            } else {
                int middle = start + (end - start) / 2;
                Task subTask1 = new Task(start, middle);
                Task subTask2 = new Task(middle, end);

                subTask1.fork();
                subTask2.fork();
            }
        }
    }


    static class TaskRet extends RecursiveTask<Long> {

        private int start;
        private int end;

        public TaskRet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= MAX_NUM) {
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum += NUMS[i];
                }

                System.out.println("from: " + start + " to: " + end + " = " + sum);

                return sum;
            } else {
                int middle = start + (end - start) / 2;
                TaskRet subTask1 = new TaskRet(start, middle);
                TaskRet subTask2 = new TaskRet(middle, end);

                subTask1.fork();
                subTask2.fork();
                return subTask1.join() + subTask2.join();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Task task = new Task(0, NUMS.length);
        forkJoinPool.execute(task);

        System.out.println("------带有返回值的------");
        TaskRet taskRet = new TaskRet(0, NUMS.length);

        /*long sum = forkJoinPool.submit(taskRet).get();
        System.out.println("和：" + sum);*/
        forkJoinPool.execute(taskRet);
        long sum = taskRet.join();
        System.out.println("和：" + sum);

        System.in.read();
    }

}
