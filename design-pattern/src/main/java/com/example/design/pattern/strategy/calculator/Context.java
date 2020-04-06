package com.example.design.pattern.strategy.calculator;

public class Context {
    private Calculator calculator;

    public Context(Calculator calculator) {
        this.calculator = calculator;
    }

    public int exec(int a, int b, String symbol) {
        return this.calculator.exec(a, b);
    }
}
