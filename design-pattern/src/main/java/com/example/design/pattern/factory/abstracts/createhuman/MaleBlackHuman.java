package com.example.design.pattern.factory.abstracts.createhuman;

public class MaleBlackHuman extends AbstractBlackHuman {
    @Override
    public void getSex() {
        System.out.println("黑人男性！");
    }
}
