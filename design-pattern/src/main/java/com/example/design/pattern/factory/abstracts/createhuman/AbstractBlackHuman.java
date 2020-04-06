package com.example.design.pattern.factory.abstracts.createhuman;


public abstract class AbstractBlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黑人的皮肤是黑色的！");
    }

    @Override
    public void talk() {
        System.out.println("黑人可以说话！");
    }
}
