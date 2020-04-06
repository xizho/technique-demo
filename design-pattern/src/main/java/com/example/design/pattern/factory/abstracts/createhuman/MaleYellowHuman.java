package com.example.design.pattern.factory.abstracts.createhuman;

public class MaleYellowHuman extends AbstractYellowHuman {
    @Override
    public void getSex() {
        System.out.println("黄人男性！");
    }
}
