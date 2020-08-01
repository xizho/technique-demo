package com.example.design.pattern.observer.event.subscribes;

import com.example.design.pattern.observer.event.roles.EventListener;

public class LoggingListener implements EventListener {

    @Override
    public void update(String eventType, Object data) {
        System.out.println("log" + eventType + " something :" + data);
    }
}
