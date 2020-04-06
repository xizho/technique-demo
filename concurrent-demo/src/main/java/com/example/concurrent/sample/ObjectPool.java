package com.example.concurrent.sample;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * 对象池的实现，
 *
 * @param <T>
 * @param <R>
 */
public class ObjectPool<T, R> {

    final List<T> pool;

    final Semaphore semaphore;

    public ObjectPool(int size, T t) {
        this.pool = new Vector<>();
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }

        this.semaphore = new Semaphore(size);
    }

    R exec(Function<T, R> function) {
        T t = null;
        try {
            semaphore.acquire();
            t = pool.remove(0);
            // TODO 少了一步，apply的实现过程
            return function.apply(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pool.add(t);
            semaphore.release();
        }

        return null;
    }

    static class Demo {
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        ObjectPool<Integer, String> pool = new ObjectPool(10, "demo");
        pool.exec(t -> {
            System.out.println(t);
            return t.toString();
        });
    }

}
