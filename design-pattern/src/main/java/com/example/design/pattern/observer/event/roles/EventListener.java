package com.example.design.pattern.observer.event.roles;

/**
 * 订阅者
 *
 * @author xizho
 */
public interface EventListener {

    /**
     * 订阅接受消息
     *
     * @param eventType
     * @param data
     */
    void update(String eventType, Object data);
}
