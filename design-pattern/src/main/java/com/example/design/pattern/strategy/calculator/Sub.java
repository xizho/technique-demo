package com.example.design.pattern.strategy.calculator;

public class Sub implements Calculator {
    @Override
    public int exec(int a, int b) {
        return a - b;
    }
}
