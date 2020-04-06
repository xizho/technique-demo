package com.example.design.pattern.observer.sample;

import java.util.concurrent.TimeUnit;

public class ClienMain {
    public static void main(String[] args) {
        Lisi lisi = new Lisi();
        Hanfeizi hanfeizi = new Hanfeizi();
        Spy spyBreakfast = new Spy(hanfeizi, lisi, "breakfast");
        spyBreakfast.start();
        Spy spyFun = new Spy(hanfeizi, lisi, "fun");
        spyFun.start();


        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        hanfeizi.haveBreakfast();

        try {
            TimeUnit.SECONDS.sleep(5L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hanfeizi.hanFun();
    }
}
