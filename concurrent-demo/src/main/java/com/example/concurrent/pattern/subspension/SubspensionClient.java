package com.example.concurrent.pattern.subspension;

public class SubspensionClient {

    public static void main(String[] args) throws InterruptedException {
        final RequestQueue queue = new RequestQueue();
        new ClientThread(queue, "Seen").start();
        ServerThread serverThread = new ServerThread(queue);
        serverThread.start();

        Thread.sleep(5000);

        serverThread.close();
    }
}
