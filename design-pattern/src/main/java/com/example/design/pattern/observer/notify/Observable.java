package com.example.design.pattern.observer.notify;

public interface Observable {
    public void addObserver(Observer observable);

    public void delObserver(Observer observable);

    public void notifyObserver(String context);
}
