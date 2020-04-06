package com.example.design.pattern.factory.method.createhuman;

/**
 * 人类创建工厂
 */
public class HunmanFactory extends AbstractHumanFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> clazz) {
        Human human = null;
        try {
            human = clazz.newInstance();
//            human = (Human) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return (T) human;
    }
}
