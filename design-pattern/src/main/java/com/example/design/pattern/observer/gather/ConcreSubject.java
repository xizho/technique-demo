package com.example.design.pattern.observer.gather;

public class ConcreSubject extends Subject {

    public void doSth() {
        System.out.println("do something..");
        super.notifyObserver();
    }
}
