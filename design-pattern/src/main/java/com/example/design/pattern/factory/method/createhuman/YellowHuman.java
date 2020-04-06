package com.example.design.pattern.factory.method.createhuman;

public class YellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黄人的皮肤是黄色的！");
    }

    @Override
    public void talk() {
        System.out.println("黄人可以说话！");
    }
}
