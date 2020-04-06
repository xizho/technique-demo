package com.example.concurrent.pattern.activeobject;

public class ActiveObjectFactory {

    private ActiveObjectFactory() {
    }

    public static ActiveObject createActiveObject() {
        Servant servant = new Servant();
        ActivatingQueue activatingQueue = new ActivatingQueue();
        SchedulerThread schedulerThread = new SchedulerThread(activatingQueue);
        ActiveObjectProxy activeObjectProxy = new ActiveObjectProxy(schedulerThread, servant);

        schedulerThread.start();

        return activeObjectProxy;
    }


}
