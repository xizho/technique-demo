package com.example.design.pattern.observer.event.roles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {

    private Map<String, List<EventListener>> listenerMap = new HashMap<>();

    public EventManager(Editor.EventType... eventTypes) {
        for (Editor.EventType eventType : eventTypes) {
            this.listenerMap.put(eventType.type, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> listeners = listenerMap.get(eventType);
        listeners.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> listeners = listenerMap.get(eventType);
        listeners.remove(listener);
    }

    public void notify(String eventType, Object data) {
        List<EventListener> listeners = listenerMap.get(eventType);
        listeners.forEach(listener -> listener.update(eventType, data));
    }

}
