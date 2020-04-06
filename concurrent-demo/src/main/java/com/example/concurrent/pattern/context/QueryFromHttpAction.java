package com.example.concurrent.pattern.context;

public class QueryFromHttpAction {

    public void execute() {
        Context context = ActionContext.getActionContext().getContext();
        String name = context.getName();
        String cardId = getCardId(name);
        context.setCardId(cardId);
    }

    private String getCardId(String name) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "123132" + Thread.currentThread().getId();
    }

}
