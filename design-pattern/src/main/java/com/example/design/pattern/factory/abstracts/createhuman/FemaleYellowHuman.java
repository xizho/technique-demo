package com.example.design.pattern.factory.abstracts.createhuman;

public class FemaleYellowHuman extends AbstractYellowHuman {
    @Override
    public void getSex() {
        System.out.println("黄人女性！");
    }
}
