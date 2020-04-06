package com.example.concurrent.pattern.activeobject;

public class DisplayClientThread extends Thread {

    private final ActiveObject activeObject;

    public DisplayClientThread(ActiveObject activeObject, String name) {
        super(name);
        this.activeObject = activeObject;
    }

    @Override
    public void run() {
        for (int i = 0; true; i++) {
            String text = Thread.currentThread().getName() + "=>" + i;
            activeObject.displayString(text);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
