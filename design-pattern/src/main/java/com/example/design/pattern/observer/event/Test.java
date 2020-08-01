package com.example.design.pattern.observer.event;

import com.example.design.pattern.observer.event.roles.Editor;
import com.example.design.pattern.observer.event.roles.EventManager;
import com.example.design.pattern.observer.event.subscribes.EmailListener;
import com.example.design.pattern.observer.event.subscribes.LoggingListener;

public class Test {

    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        Editor editor = new Editor();

        LoggingListener loggingListener = new LoggingListener();
        eventManager.subscribe("open", loggingListener);

        EmailListener emailListener = new EmailListener();
        eventManager.subscribe("save", emailListener);

        editor.openFile("demo/text.txt");
        editor.saveFile();

        // 取消订阅
        eventManager.unsubscribe("open", loggingListener);
        eventManager.unsubscribe("save", emailListener);
    }

}
