package com.example.design.pattern.observer.gather;

public class Hanfeizi implements IHanfeizi {
    private ILisi lisi = new Lisi();

    /*public Hanfeizi(ILisi lisi) {
        this.lisi = lisi;
    }*/

    @Override
    public void haveBreakfast() {
        System.out.println("韩非子开始吃早饭了。。。");
        this.lisi.update("韩非子在吃饭。。。");
    }

    @Override
    public void hanFun() {
        System.out.println("韩非子开始娱乐了。。。");
        this.lisi.update("韩非子在娱乐。。。");
    }
}
