package com.example.concurrent.pattern.future;

public class FutureTest {

    public static void main(String[] args) throws InterruptedException {
        FutureService futureService = new FutureService();
        futureService.submit(() -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Finished.";
        }, System.out::println);

        System.out.println("============");
        System.out.println("do other thing.");
        Thread.sleep(1000L);
        System.out.println("============");

//        System.out.println(future.get());
    }

}
