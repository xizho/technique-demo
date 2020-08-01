package com.example.design.pattern.observer.notify;

public class ClientMain {
    public static void main(String[] args) {
        Observer lisi   = new Lisi();
        Observer wangsi = new Wangsi();
        Observer liusi  = new Liusi();

        Hanfeizi hanfeizi = new Hanfeizi();
        hanfeizi.addObserver(lisi);
        hanfeizi.addObserver(wangsi);
        hanfeizi.addObserver(liusi);

        hanfeizi.haveBreakfast();
    }
}
