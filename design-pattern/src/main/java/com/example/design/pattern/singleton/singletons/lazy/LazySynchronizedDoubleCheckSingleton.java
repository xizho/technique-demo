package com.example.design.pattern.singleton.singletons.lazy;

public class LazySynchronizedDoubleCheckSingleton {

    private volatile static LazySynchronizedDoubleCheckSingleton lazySingleton = null;

    private LazySynchronizedDoubleCheckSingleton() {
    }

    /**
     * 性能较好
     *
     * @return
     */
    public static LazySynchronizedDoubleCheckSingleton getInstance() {
        if (lazySingleton == null) {
            synchronized (LazySynchronizedDoubleCheckSingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new LazySynchronizedDoubleCheckSingleton();
                }
            }
        }

        return lazySingleton;
    }

}
