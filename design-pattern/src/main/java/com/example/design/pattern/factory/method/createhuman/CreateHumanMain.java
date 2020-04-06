package com.example.design.pattern.factory.method.createhuman;

public class CreateHumanMain {
    public static void main(String[] args) {
        AbstractHumanFactory yinyanglu = new HunmanFactory();

        System.out.println("造白人");
        WhiteHuman whiteHuman = yinyanglu.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();


        System.out.println("造黑人");
        BlackHuman blackHuman = yinyanglu.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();

        System.out.println("造黄人");
        YellowHuman yellowHuman = yinyanglu.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();
    }
}
