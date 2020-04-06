package com.example.concurrent.lock;

import java.util.*;

/**
 * @author zhong
 */
public class BooleanLock implements Lock {

    private boolean initValue;

    private Collection<Thread> blockedThreadCollection = new LinkedHashSet<>();

    private Thread currentThread;

    public BooleanLock() {
        this.initValue = false;
    }

    public BooleanLock(boolean initValue) {
        this.initValue = initValue;
    }

    @Override
    public synchronized void lock() throws InterruptedException {
        // 第一条线程进来，initValue = false，不走循环。第二条进来时，如果第一条线程未执行结束，则进入循环，当前线程被阻塞
        if (initValue) {
            // 将即将阻塞的线程加入集合中，统一线程可能会多次添加，所以集合类型选择Set
            blockedThreadCollection.add(Thread.currentThread());
            // 线程阻塞
            this.wait();
        }

        blockedThreadCollection.remove(Thread.currentThread());
        this.initValue = true;
        this.currentThread = Thread.currentThread();
    }

    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeOutException {
        if (mills <= 0) {
            lock();
            return;
        }

        long hasRemain = mills;
        long endTime = System.currentTimeMillis() + mills;
        while (initValue) {
            if (hasRemain <= 0) {
                throw new TimeOutException(" time out..");
            }

            blockedThreadCollection.add(Thread.currentThread());
            this.wait(mills);
            hasRemain = endTime - System.currentTimeMillis();
        }

        blockedThreadCollection.remove(Thread.currentThread());
        this.initValue = true;
        this.currentThread = Thread.currentThread();
    }

    @Override
    public synchronized void unlock() throws InterruptedException {
        if (Thread.currentThread() == currentThread) {
            this.initValue = false;
            Optional.of(Thread.currentThread().getName() + " release the lock monitor.")
                    .ifPresent(System.out::println);
            this.notifyAll();
        }
    }

    @Override
    public Collection<Thread> getBlockedThread() {
        return Collections.unmodifiableCollection(blockedThreadCollection);
    }

    @Override
    public int getBlockedSize() {
        return blockedThreadCollection.size();
    }
}
