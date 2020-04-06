package com.example.concurrent.pattern.activeobject;

public class ActiveObjectClient {

    public static void main(String[] args) {

        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();

        new MakeClientThread(activeObject, "Alice").start();
        new MakeClientThread(activeObject, "Bobby").start();

        new DisplayClientThread(activeObject, "Chris").start();
    }
}
