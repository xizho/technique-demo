package com.example.design.pattern.factory.abstracts.createhuman;

public abstract class AbstractWhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("白人的皮肤是白色的！");
    }

    @Override
    public void talk() {
        System.out.println("白人可以说话！");
    }
}
