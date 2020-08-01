package com.example.pool.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadPool extends ThreadPoolExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyThreadPool.class);

    private String threadNamePrefix;

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, String threadNamePrefix) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, new MyThreadFactory(threadNamePrefix), new MyRejectedExecutionHandler(threadNamePrefix));
        this.threadNamePrefix = threadNamePrefix;
    }

    /**
     * 自定义线程生成方式
     */
    static class MyThreadFactory implements ThreadFactory {

        private AtomicInteger count = new AtomicInteger();

        private String threadNamePrefix;

        public MyThreadFactory(String threadNamePrefix) {
            this.threadNamePrefix = threadNamePrefix;
        }

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, threadNamePrefix + "-" + count.incrementAndGet());
        }
    }

    /**
     * 自定义拒绝策略
     */
    public static class MyRejectedExecutionHandler implements RejectedExecutionHandler {

        private String threadNamePrefix;


        public MyRejectedExecutionHandler(String threadNamePrefix) {
            this.threadNamePrefix = threadNamePrefix;
        }


        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            if (!executor.isShutdown()) {
                LOGGER.warn("ThreadPool [{}] is full, the thread [{}] cannot work.", threadNamePrefix, r);
            }
        }
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
//        LOGGER.info("[{}] execute [{}]", t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
//        LOGGER.info("after execute [{}]", r);
        LOGGER.info("Threadl Pool:[{}], corePoolSize:[{}], maximumPoolSize:[{}], aliveThreadCount:[{}], CompletedTaskThrealCount:[{}]",
//                now(),
                threadNamePrefix,
                getCorePoolSize(),
                getMaximumPoolSize(),
                getActiveCount(),
                getCompletedTaskCount());
    }

    private String now() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").format(LocalDateTime.now());
    }

}
