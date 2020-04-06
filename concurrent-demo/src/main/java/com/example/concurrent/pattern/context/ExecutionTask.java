package com.example.concurrent.pattern.context;

public class ExecutionTask implements Runnable {

    private QueryFromDBAction queryFromDBAction = new QueryFromDBAction();
    private QueryFromHttpAction queryFromHttpAction = new QueryFromHttpAction();

    @Override
    public void run() {
        final Context context = ActionContext.getActionContext().getContext();
        queryFromDBAction.execute();
        System.out.println("The name query successful.");
        queryFromHttpAction.execute();
        System.out.println("The cardId query successful.");
        System.out.println("The name is " + context.getName() + " and the cardId is " + context.getCardId());
    }
}
