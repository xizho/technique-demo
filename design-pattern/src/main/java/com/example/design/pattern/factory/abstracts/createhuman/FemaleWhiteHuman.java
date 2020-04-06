package com.example.design.pattern.factory.abstracts.createhuman;

public class FemaleWhiteHuman extends AbstractWhiteHuman {
    @Override
    public void getSex() {
        System.out.println("白人女性！");
    }
}
