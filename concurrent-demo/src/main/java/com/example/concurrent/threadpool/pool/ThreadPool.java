package com.example.concurrent.threadpool.pool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

@Configuration
@EnableAsync
public class ThreadPool {

    private int corePoolSize = 1;
    private int maxPoolSize = 3;
    private int queueCapacity = 1;
    private int keepAlive = 10;
    private int scheduledSize = 5;
    private String executorName = "my-executor-";

    @Bean
    public Executor myExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(executorName);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        // 当线程池线程达到，
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());

        executor.setKeepAliveSeconds(keepAlive);
        executor.initialize();

        return executor;
    }

    @Bean
    public ScheduledExecutorService scheduledFuture() {
        return Executors.newScheduledThreadPool(scheduledSize);
    }


}
