package com.example.design.pattern.strategy.enums;

public class ClientMain {
    public static final String ADD = "+";
    public static final String SUB = "-";

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        String symbol = args[1];
        int b = Integer.parseInt(args[2]);

        int result = 0;
        if (ADD.equalsIgnoreCase(symbol)) {
            result = CalculatorEnum.ADD.exec(a, b);
        }

        if (SUB.equalsIgnoreCase(symbol)) {
            result = CalculatorEnum.SUB.exec(a, b);
        }

        System.out.println("运行结果：" + a + symbol + b + " = " + result);
    }
}
