package com.example.design.pattern.strategy.calculator;

public class ClientMain {

    public static final String ADD = "+";
    public static final String SUB = "-";

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        String symbol = args[1];
        int b = Integer.parseInt(args[2]);

        Context context = null;
        if (ADD.equalsIgnoreCase(symbol)) {
            context = new Context(new Add());
        }

        if (SUB.equalsIgnoreCase(symbol)) {
            context = new Context(new Sub());
        }

        System.out.println("运行结果：" + a + symbol + b + " = " + context.exec(a, b, symbol));
    }

}
