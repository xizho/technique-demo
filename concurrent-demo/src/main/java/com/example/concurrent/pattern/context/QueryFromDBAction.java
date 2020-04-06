package com.example.concurrent.pattern.context;

public class QueryFromDBAction {

    public void execute() {
        try {
            Thread.sleep(1000);
            String name = "Seen " + Thread.currentThread().getName();
            ActionContext.getActionContext().getContext().setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
