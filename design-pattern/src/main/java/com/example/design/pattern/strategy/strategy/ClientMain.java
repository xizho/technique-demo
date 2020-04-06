package com.example.design.pattern.strategy.strategy;

public class ClientMain {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategy1());
        context.doAth();
        context = new Context(new ConcreteStrategy2());
        context.doAth();
    }
}
