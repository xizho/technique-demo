package com.example.concurrent.lock;

public class SyncronizedProblem {


    public static void main(String[] args) {
//        Thread t1 = new Thread(SyncronizedProblem::run).start();
    }

    private synchronized static void run() throws InterruptedException {
        while (true) {
            Thread.sleep(1000_000);
        }
    }

}
