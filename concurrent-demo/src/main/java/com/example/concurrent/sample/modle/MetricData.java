package com.example.concurrent.sample.modle;

import lombok.Data;

import java.util.List;

@Data
public class MetricData {
    private Metric metric;
    private List<Object> value;
}
