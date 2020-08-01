package com.example.design.pattern.strategy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 策略枚举
 */
@Getter
@AllArgsConstructor
public enum CalculatorEnum {
    /**
     * 加
     */
    ADD("+") {
        @Override
        int exec(int a, int b) {
            return a + b;
        }
    },

    /**
     * 减
     */
    SUB("-") {
        @Override
        int exec(int a, int b) {
            return a - b;
        }
    };

    String value;

    abstract int exec(int a, int b);
}
