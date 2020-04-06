package com.example.design.pattern.proxy.dynamic.common;

public class RealSubject implements Subject {
    @Override
    public void doSth(String sth) {
        System.out.println("do something: " + sth);
    }
}
