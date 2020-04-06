package com.example.concurrent.pattern.activeobject;

import java.util.LinkedList;

public class ActivatingQueue {

    private final static int MAX_METHOD_REQUEST_QUEUE_SIZE = 100;


    private final LinkedList<MethodRequest> methodQueue;

    public ActivatingQueue() {
        methodQueue = new LinkedList<>();
    }


    public synchronized void put(MethodRequest request) {
        while (methodQueue.size() >= MAX_METHOD_REQUEST_QUEUE_SIZE) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.methodQueue.addLast(request);
        this.notifyAll();
    }


    public synchronized MethodRequest take() {
        while (this.methodQueue.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        MethodRequest request = methodQueue.removeFirst();
        this.notifyAll();

        return request;
    }


}
