package com.example.other.test.concurrent.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest {

    public static void main(String[] args) {

//        demo1();
        demo2();
    }

    private static void demo2() {
        CompletableFuture<Double> doubleCompletableFuture = CompletableFuture.supplyAsync(CompletableFutureTest::fetchPrice);
        doubleCompletableFuture.thenApply((r) -> {
            System.out.println("price: " + r);
            return r;
        });

        doubleCompletableFuture.exceptionally(e -> {
            e.printStackTrace();
            System.out.println("exception: " + e.getMessage());
            return null;
        });

        try {
            TimeUnit.SECONDS.sleep(4L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Double fetchPrice() {
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed.");
        }

        return 5 + Math.random() * 20;
    }

    static void demo1() {
        CompletableFuture.supplyAsync(() -> 1)
                .thenApply(i -> i + 1)
                .thenApply(i -> i * i)
                .whenComplete((r, e) -> System.out.println(r + " : " + e));

        CompletableFuture.supplyAsync(() -> "Hello ")
                .thenApply(s -> s + "world!")
                .thenApply(String::toUpperCase)
                .whenComplete((r, e) -> System.out.println(r));

        /*
         * 等待其他阶段完成，一起处理，类似CountDownLatch
         *
         */
        CompletableFuture.supplyAsync(() -> "Hello ")
                .thenApply(s -> s + "world, ")
                .thenApply(String::toUpperCase)
                .thenCombine(CompletableFuture.completedFuture("Java."), (s1, s2) -> s1 + s2)
                .thenAccept(System.out::println);

        /*
         * 复杂点的计算
         */
        String[] list = {"a", "b", "c"};
        List<CompletableFuture> resultList = new ArrayList<>();
        for (String s : list) {
            resultList.add(CompletableFuture.supplyAsync(() -> s).thenApply(String::toUpperCase));
        }

        CompletableFuture.allOf(
                resultList.toArray(new CompletableFuture[resultList.size()]))
                .whenComplete((r, e) -> {
                    if (null == e) {
                        System.out.println(e);
                    } else {
                        throw new RuntimeException("异常了");
                    }
                });


        CompletableFuture<String> message = CompletableFuture.completedFuture("message");
        if (message.isDone()) {
            System.out.println(message.getNow("null"));
        }
    }
}
