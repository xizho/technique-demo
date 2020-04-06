package com.example.design.pattern.factory.abstracts.createhuman;

public class MaleWhiteHuman extends AbstractWhiteHuman {
    @Override
    public void getSex() {
        System.out.println("白人男性！");
    }
}
