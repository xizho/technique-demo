package com.example.design.pattern.strategy.strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doAth() {
        this.strategy.doSth();
    }
}
