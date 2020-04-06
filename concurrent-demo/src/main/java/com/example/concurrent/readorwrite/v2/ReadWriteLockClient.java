package com.example.concurrent.readorwrite.v2;

public class ReadWriteLockClient {

    public static void main(String[] args) {
        SharedData data = new SharedData(10);
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();


        new WriterWorker(data, "qweqoqoeuuoi").start();
        new WriterWorker(data, "QWEQOQOEUUOI").start();
    }
}
