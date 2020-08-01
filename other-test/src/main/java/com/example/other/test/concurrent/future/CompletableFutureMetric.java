package com.example.other.test.concurrent.future;


import com.example.other.test.modle.Metric;
import com.example.other.test.modle.MetricData;
import com.example.other.test.modle.Response;
import com.example.other.test.modle.ReturnMetric;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureMetric {

    public static void main(String[] args) throws Exception {
        Instant start = Instant.now();
        new CompletableFutureMetric().getMetricV2();
        Instant end = Instant.now();
        System.out.printf("耗时：[%d] ms", Duration.between(start, end).toMillis());
    }


    /**
     * 第二版，完成目标，所耗时间为一个请求的耗时，2s左右
     *
     * @throws Exception
     */
    void getMetricV2() throws Exception {
        Response<List<ReturnMetric>> response = new Response<>();
        response.setCode("200");
        response.setMessage("Successfully");

        List<List<String>> metricLists = new ArrayList();
        List<String> readMetrics = new ArrayList<>();
        readMetrics.add("read_cur");
        readMetrics.add("read_day");
        readMetrics.add("read_week");
        List<String> writeMetrics = new ArrayList<>();
        writeMetrics.add("write_cur");
        writeMetrics.add("write_day");
        writeMetrics.add("write_week");
        List<String> totalMetrics = new ArrayList<>();
        totalMetrics.add("read");
        totalMetrics.add("write");

        metricLists.add(readMetrics);
        metricLists.add(writeMetrics);
        metricLists.add(totalMetrics);

        List<CompletableFuture<List<MetricData>>> completableFutureList = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 指标获取中
        metricLists.forEach(metricList -> completableFutureList.add(basicCompletableFuture(metricList, executorService)));


        // 结果汇总
        CompletableFuture<List<MetricData>>[] futures = new CompletableFuture[completableFutureList.size()];
        completableFutureList.toArray(futures);
        List<ReturnMetric> metricData = new ArrayList<>();

        CompletableFuture.allOf(futures)
                .whenComplete((r, e) -> Arrays.stream(futures).forEach(future -> {
                    try {
                        ReturnMetric metric = new ReturnMetric();
                        metric.setMetricData(future.get());
                        metricData.add(metric);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                })).join();

        response.setData(metricData);

        executorService.shutdown();

        System.out.println(new ObjectMapper().writeValueAsString(response));
    }


    /**
     * 提取公共的封装
     * 但也存在问题：list -> array -> list
     *
     * @param metrics
     * @param executorService
     * @return
     */
    CompletableFuture<List<MetricData>> basicCompletableFuture(List<String> metrics, ExecutorService executorService) {
        return CompletableFuture.supplyAsync(() -> {
            List<MetricData> metricData = new ArrayList<>();

            List<CompletableFuture<MetricData>> completableFutureList = new ArrayList<>();
            metrics.forEach(metric -> completableFutureList.add(CompletableFuture.supplyAsync(() -> metric(metric), executorService)));

            CompletableFuture<MetricData>[] futures = new CompletableFuture[completableFutureList.size()];
            completableFutureList.toArray(futures);
            CompletableFuture.allOf(futures).whenComplete((r, e) -> {
                for (CompletableFuture<MetricData> future1 : futures) {
                    try {
                        metricData.add(future1.get());
                    } catch (Exception executionException) {
                        executionException.printStackTrace();
                    }
                }
            }).join();

            return metricData;
        }, executorService);
    }


    /**
     * 第一版，没有利用CompletableFuture.whenComplete的特性，需要新增代码来判断有没有完成，待完善。
     *
     * @throws Exception
     */
    void getMetric() throws Exception {
        Response<ReturnMetric> response = new Response<>();
        response.setCode("200");
        response.setMessage("Successfully");

        ReturnMetric responseData = new ReturnMetric();

        System.out.println("read: " + Instant.now());
        // read increment
        CompletableFuture<List<MetricData>> readIncr = CompletableFuture.supplyAsync(() -> {
            List<MetricData> metricData = new ArrayList<>();
            List<String> metrics = new ArrayList<>();
            metrics.add("read_cur");
            metrics.add("read_day");
            metrics.add("read_week");

            metrics.forEach(metric -> {
                CompletableFuture<MetricData> completableFuture = CompletableFuture.supplyAsync(() -> metric(metric)).whenComplete((r, e) -> metricData.add(r));
                while (!completableFuture.isDone()) ;
            });

            return metricData;
        });

        System.out.println("write: " + Instant.now());
        // write increment
        CompletableFuture<List<MetricData>> writeIncr = CompletableFuture.supplyAsync(() -> {
            List<MetricData> metricData = new ArrayList<>();
            List<String> metrics = new ArrayList<>();
            metrics.add("write_cur");
            metrics.add("write_day");
            metrics.add("write_week");

            metrics.forEach(metric -> {
                CompletableFuture<MetricData> completableFuture = CompletableFuture.supplyAsync(() -> metric(metric)).whenComplete((r, e) -> metricData.add(r));
                while (!completableFuture.isDone()) ;
            });

            return metricData;
        });

        System.out.println("total: " + Instant.now());
        // total
        CompletableFuture<List<MetricData>> allTotal = CompletableFuture.supplyAsync(() -> {
            List<MetricData> metricData = new ArrayList<>();
            List<String> metrics = new ArrayList<>();
            metrics.add("read");
            metrics.add("write");

            metrics.forEach(metric -> {
                CompletableFuture<MetricData> completableFuture = CompletableFuture.supplyAsync(() -> metric(metric)).whenComplete((r, e) -> metricData.add(r));
                while (!completableFuture.isDone()) ;
            });
            return metricData;
        });


        // 结果汇总
        CompletableFuture<List<MetricData>>[] futures = new CompletableFuture[]{readIncr, writeIncr, allTotal};
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures)
                .whenComplete((r, e) -> {
                    Arrays.stream(futures).forEach(future -> {
                        try {
                            responseData.setMetricData(future.get());
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    });
                });

        while (!allOf.isDone()) ;
    }

    private MetricData metric(String name) {
        try {
            System.out.printf("获取%s的指标中。。。\n", name);
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
