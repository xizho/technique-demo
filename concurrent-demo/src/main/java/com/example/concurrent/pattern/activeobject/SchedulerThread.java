package com.example.concurrent.pattern.activeobject;

public class SchedulerThread extends Thread {

    private final ActivatingQueue activatingQueue;

    public SchedulerThread(ActivatingQueue activatingQueue) {
        this.activatingQueue = activatingQueue;
    }

    public void invoke(MethodRequest request) {
        this.activatingQueue.put(request);
    }

    @Override
    public void run() {
        while (true) {
            activatingQueue.take().execute();
        }
    }
}
