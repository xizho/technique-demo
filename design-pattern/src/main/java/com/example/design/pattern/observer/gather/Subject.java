package com.example.design.pattern.observer.gather;

import com.example.design.pattern.observer.notify.Observer;

import java.util.Vector;

public abstract class Subject {
    Vector<Observer> observers = new Vector<>();

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void delObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update("通知。。");
        }
    }
}
