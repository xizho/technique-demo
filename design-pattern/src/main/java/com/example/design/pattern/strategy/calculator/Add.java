package com.example.design.pattern.strategy.calculator;

public class Add implements Calculator {
    @Override
    public int exec(int a, int b) {
        return a + b;
    }
}
