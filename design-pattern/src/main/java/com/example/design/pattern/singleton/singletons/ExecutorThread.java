package com.example.design.pattern.singleton.singletons;

import com.example.design.pattern.singleton.singletons.lazy.LazyInnerClassSingleton;

public class ExecutorThread implements Runnable {

    @Override
    public void run() {
        LazyInnerClassSingleton singleton = LazyInnerClassSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + singleton);

    }
}
