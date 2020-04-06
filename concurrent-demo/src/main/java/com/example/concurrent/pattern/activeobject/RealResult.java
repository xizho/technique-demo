package com.example.concurrent.pattern.activeobject;

public class RealResult implements Result {

    private final Object realResult;


    public RealResult(final Object realResult) {
        this.realResult = realResult;
    }

    @Override
    public Object getResultValue() {
        return this.realResult;
    }
}
