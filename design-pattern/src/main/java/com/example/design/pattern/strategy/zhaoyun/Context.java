package com.example.design.pattern.strategy.zhaoyun;

public class Context {
    IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void operate() {
        this.strategy.operate();
    }
}
