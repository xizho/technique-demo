package com.example.design.pattern.observer.event.roles;

import java.io.File;

public class Editor {

    private EventManager eventManager;

    private File file;

    public Editor() {
        this.eventManager = new EventManager(EventType.values());
    }

    public void openFile(String path) {
        this.file = new File(path);
        eventManager.notify(EventType.OPEN.type, file.getName());
    }

    public void saveFile() {
        System.out.println("file is saved.");
        eventManager.notify(EventType.SAVE.type, file.getName());
    }

    public enum EventType {
        OPEN("open"), DELETE("delete"), SAVE("save"), CLOSE("close");

        String type;

        EventType(String type) {
            this.type = type;
        }
    }

}
