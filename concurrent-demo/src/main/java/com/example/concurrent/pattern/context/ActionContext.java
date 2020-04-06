package com.example.concurrent.pattern.context;

public class ActionContext {

    private static final ThreadLocal<Context> CONTEXT_THREAD_LOCAL = ThreadLocal.withInitial(() -> new Context());

    private static class ContextHolder {
        private final static ActionContext actionContext = new ActionContext();
    }

    public static ActionContext getActionContext() {
        return ContextHolder.actionContext;
    }

    public Context getContext() {
        return CONTEXT_THREAD_LOCAL.get();
    }
}
