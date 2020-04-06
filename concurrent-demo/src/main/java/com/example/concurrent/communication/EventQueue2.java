package com.example.concurrent.communication;

import java.util.LinkedList;

/**
 * 类职责：<br/>
 *
 * <p>Title: EventQueue.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 </p>
 * <p>Company: </p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月18日 下午下午 5:57
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class EventQueue2 {

    private final int max;

    static class Event {
    }

    private final LinkedList<Event> eventQueue = new LinkedList<>();

    private final static int DEFAULT_MAX_EVENT = 1;

    public EventQueue2() {
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue2(int max) {
        this.max = max;
    }

    public void offer(Event event) {
        synchronized (eventQueue) {
            while (eventQueue.size() >= max) {
                try {
                    console(" the queue is full.");
                    console(" full queue size is " + eventQueue.size());
                    console(" before offer wait thread...");
                    eventQueue.wait();
                    console(" after offer wait thread...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            console(" the new event is submitted.");
            console(" before add queue size is " + eventQueue.size());
            eventQueue.addLast(event);
            console(" after add queue size is " + eventQueue.size());
            eventQueue.notifyAll();
            console(" offer notify thread.. ");
        }
    }

    public Event take() {
        synchronized (eventQueue) {
            while (eventQueue.isEmpty()) {
                console(" empty queue size is " + eventQueue.size());
                console(" the queue is empty.");
                try {
                    console(" before take wait thread...");
                    eventQueue.wait();
                    console(" after take wait thread...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            console(" before remove queue size is " + eventQueue.size());
            Event event = eventQueue.removeFirst();
            console(" after remove queue size is " + eventQueue.size());
            this.eventQueue.notifyAll();
            console(" take notify thread..");
            console(" the event " + event + " is handled.");
            return event;
        }
    }

    private void console(String message) {
        System.out.printf("%s :%s\n", Thread.currentThread().getName(), message);
    }

}
