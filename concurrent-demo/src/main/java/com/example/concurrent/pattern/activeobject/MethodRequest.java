package com.example.concurrent.pattern.activeobject;

public abstract class MethodRequest {

    protected final Servant servant;
    protected final FutureResult futureResult;

    public MethodRequest(Servant servant, FutureResult futureResult) {
        this.futureResult = futureResult;
        this.servant = servant;
    }

    public abstract void execute();

}
