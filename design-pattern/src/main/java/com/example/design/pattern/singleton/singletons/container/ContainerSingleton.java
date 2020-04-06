package com.example.design.pattern.singleton.singletons.container;

import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {

    private ContainerSingleton() {
    }

    private static ConcurrentHashMap<String, Object> IOC = new ConcurrentHashMap<>();

    public static Object getBean(String className) {
        synchronized (ContainerSingleton.class) {
            if (!IOC.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    IOC.put(className, obj);

                    return obj;
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        return IOC.get(className);
    }
}
