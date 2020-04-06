package com.example.design.pattern.factory.method.createhuman;

/**
 * 人类创建工厂
 */
public abstract class AbstractHumanFactory {
    public abstract <T extends Human> T createHuman(Class<T> clazz);
}
