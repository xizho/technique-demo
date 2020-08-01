package com.example.design.pattern.observer.event.subscribes;

import com.example.design.pattern.observer.event.roles.EventListener;

public class EmailListener implements EventListener {
    @Override
    public void update(String eventType, Object data) {
        System.out.println("send the" + eventType + " email : " + data);
    }
}
