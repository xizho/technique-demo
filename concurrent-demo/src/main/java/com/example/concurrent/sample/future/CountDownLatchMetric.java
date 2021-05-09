package com.example.concurrent.sample.future;


import com.example.concurrent.sample.modle.Metric;
import com.example.concurrent.sample.modle.MetricData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchMetric {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);


        latch.await();
        System.out.println("任务完成。。。");
    }

    public static class Task implements Callable<MetricData> {
        private final CountDownLatch latch;
        private String name;

        public Task(CountDownLatch latch, String name) {
            this.latch = latch;
            this.name = name;
        }


        @Override
        public MetricData call() throws Exception {
            System.out.printf("获取%s的指标中。。。\n", name);
            TimeUnit.SECONDS.sleep(2L);

            MetricData metricData = new MetricData();
            Metric metric = new Metric();
            metric.setName(name);
            metricData.setMetric(metric);
            List<Object> value = new ArrayList<>();
            value.add(System.currentTimeMillis());
            value.add("1598963");
            metricData.setValue(value);
            return metricData;
        }
    }

}
