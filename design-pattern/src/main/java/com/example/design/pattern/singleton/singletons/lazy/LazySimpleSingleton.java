package com.example.design.pattern.singleton.singletons.lazy;

public class LazySimpleSingleton {

    private static LazySimpleSingleton lazySingleton = null;

    private LazySimpleSingleton() {
    }

    // 性能较差，可能造成锁定整个class
    public synchronized static LazySimpleSingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySimpleSingleton();
        }

        return lazySingleton;
    }

}
