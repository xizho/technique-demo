package com.example.design.pattern.observer.jdk;

import java.util.Observable;

public class Hanfeizi extends Observable implements IHanfeizi {
    @Override
    public void haveBreakfast() {
        System.out.println("韩非子开始吃饭了。。。");
        super.setChanged();
        super.notifyObservers("韩非子在吃饭。。。");
    }

    @Override
    public void hanFun() {
        System.out.println("韩非子开始娱乐了。。。");
        super.setChanged();
        super.notifyObservers("韩非子在娱乐。。。");
    }
}
