package com.example.concurrent.pattern.activeobject;

public class MakeStringRequest extends MethodRequest {
    private final int count;

    private final char fillChar;

    public MakeStringRequest(Servant servant, FutureResult futureResult, int count, char fillChar) {
        super(servant, futureResult);

        this.fillChar = fillChar;
        this.count = count;
    }

    @Override
    public void execute() {
        Result result = servant.makeString(count, fillChar);
        futureResult.setResult(result);
    }
}
