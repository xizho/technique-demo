package com.example.design.pattern.strategy.strategy;

public class ConcreteStrategy1 implements Strategy {
    @Override
    public void doSth() {
        System.out.println("策略1");
    }
}
