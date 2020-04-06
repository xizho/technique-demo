package com.example.design.pattern.observer.notify;

import java.util.ArrayList;

public class Hanfeizi implements Observable, IHanfeizi {
    @Override
    public void haveBreakfast() {
        System.out.println("韩非子开始吃饭了。。。");
        this.notifyObserver("韩非子在吃饭。。。");
    }

    @Override
    public void hanFun() {
        System.out.println("韩非子开始娱乐了。。。");
        this.notifyObserver("韩非子在娱乐。。。");
    }

    @Override
    public void addObserver(Observer observer) {
        this.observableList.add(observer);
    }

    @Override
    public void delObserver(Observer observer) {
        this.observableList.remove(observer);
    }

    @Override
    public void notifyObserver(String context) {
        for (Observer observer : observableList) {
            observer.update(context);
        }
    }

    private ArrayList<Observer> observableList = new ArrayList<>();
}
