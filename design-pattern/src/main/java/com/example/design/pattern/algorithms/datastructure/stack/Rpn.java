package com.example.design.pattern.algorithms.datastructure.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;

public class Rpn {

    public static void main(String[] args) {
        String exp = "1+((2+3)*(4+5))";
        exp = "1+2*3-2*2";
        convert(exp);
        System.out.println("结果：");
    }

    static String convert(String exp) {
        Stack<String> ops = new Stack<>();
        Stack<Integer> val = new Stack<>();

        char[] opsChar = exp.toCharArray();
        String[] opsStr = new String[opsChar.length];
        for (int i = 0; i < opsChar.length; i++) {
            opsStr[i] = opsChar[i] + "";
        }

        StringBuilder content = new StringBuilder();

        for (int i = 0; i < opsStr.length; i++) {
            if (isNumber(opsStr[i])) {
                val.push(Integer.valueOf(opsStr[i]));
            } else {
                String o = opsStr[i];
                if ("*".equals(o)) {

                }

                if (isOps(opsStr[i])) {
                    ops.push(opsStr[i]);
                }
            }
        }

        System.out.println(ops);
        System.out.println(val);
        return null;
    }

    static boolean isNumber(String s) {
        return Pattern.matches(numberRegex, s);
    }

    static boolean isOps(String s) {
        return Pattern.matches(opsRegex, s);
    }

    static String numberRegex = "[0-9]";
    static String opsRegex = "[\\+|\\-|\\*|\\/|\\(|\\)]";

    static Map<String, Integer> opsPriorityMap = new HashMap<>(8);

    static {
        opsPriorityMap.put("+", 1);
        opsPriorityMap.put("-", 1);
        opsPriorityMap.put("*", 2);
        opsPriorityMap.put("/", 2);
        opsPriorityMap.put("(", 3);
        opsPriorityMap.put(")", 3);
    }

}
