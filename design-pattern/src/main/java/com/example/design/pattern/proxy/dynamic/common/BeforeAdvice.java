package com.example.design.pattern.proxy.dynamic.common;

public class BeforeAdvice implements IAdvice {
    @Override
    public void exec() {
        System.out.println("前置通知。。。");
    }
}
