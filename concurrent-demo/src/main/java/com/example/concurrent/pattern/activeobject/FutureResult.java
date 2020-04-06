package com.example.concurrent.pattern.activeobject;

public class FutureResult implements Result {

    private Result result;

    private boolean ready;

    public synchronized void setResult(Result result) {
        this.result = result;
        this.ready = true;
        this.notifyAll();
    }

    public synchronized Object getResultValue() {
        while (!ready) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return this.result.getResultValue();
    }

}
