package com.example.design.pattern.factory.abstracts.createhuman;

public class FemaleBlackHuman extends AbstractBlackHuman {
    @Override
    public void getSex() {
        System.out.println("黑人女性！");
    }
}
