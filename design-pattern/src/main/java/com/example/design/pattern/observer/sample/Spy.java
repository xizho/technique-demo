package com.example.design.pattern.observer.sample;

public class Spy extends Thread {
    private Hanfeizi hanfeizi;
    private Lisi lisi;
    private String type;

    public Spy(Hanfeizi hanfeizi, Lisi lisi, String type) {
        this.hanfeizi = hanfeizi;
        this.lisi = lisi;
        this.type = type;
    }

    @Override
    public void run() {
        while (true) {
            if (this.type.equalsIgnoreCase("breakfast")) {
                if (this.hanfeizi.isHavingBreakfast()) {
                    this.lisi.update("韩非子在吃饭。。。");
                    this.hanfeizi.setHavingBreakfast(false);
                }
            } else {
                if (this.hanfeizi.isHavingFun()) {
                    this.lisi.update("韩非子在娱乐。。。");
                    this.hanfeizi.setHavingFun(false);
                }
            }
        }
    }
}
