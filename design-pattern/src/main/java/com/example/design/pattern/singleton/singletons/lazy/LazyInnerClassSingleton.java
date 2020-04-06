package com.example.design.pattern.singleton.singletons.lazy;

/**
 * 无synchronized性能最优，采用了内部类加载的特性
 *
 * @author zhong
 */
public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton() {
        if (LazyHolder.LAZY != null) {
            throw new RuntimeException("实例已存在，不允许重复生成！");
        }
    }

    public static final LazyInnerClassSingleton getInstance() {
        return LazyHolder.LAZY;
    }

    private static class LazyHolder {
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }

}
