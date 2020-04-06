package com.example.design.pattern.algorithms.datastructure.stack;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RPNSolustion {

    public static void main(String[] args) {
        String s = "(1)";
        s = "123 + 210";
//      s = "2+3*6";
//      s = "(2)+3";
        s = "1-(3+5-2+(3+19-(3-1-4+(9-4-(4-(1+(3)-2)-5)+8-(3-5)-1)-4)-5)-4+3-9)-4-(3+2-5)-10";

//        s = "3-1-4+6-(3-5)-1";
        RPNSolustion rpn = new RPNSolustion();
        System.out.println(rpn.calculate(s));
    }


    public int calculate(String s) {
        Stack<Integer> valStack = new Stack<>();
        Stack<String> opsStack = new Stack<>();

        Map<String, Integer> opsPriorityMap = opsPriority();
        char[] opsChar = s.toCharArray();
        String[] opsStr = new String[opsChar.length];
        for (int i = 0; i < opsChar.length; i++) {
            opsStr[i] = opsChar[i] + "";
        }

        for (int i = 0, length = opsStr.length; i < length; i++) {
            String letter = opsStr[i];
            if (" ".equals(letter)) continue;

            if ("(".equals(letter)) {
                opsStack.push(letter);
            } else if ("+-*/".contains(letter)) {
                String stackTop;
                while (!opsStack.isEmpty() && !("(".equals(stackTop = opsStack.peek()))
                        && (opsPriorityMap.get(letter) <= opsPriorityMap.get(stackTop))) {
                    String op = opsStack.pop();
                    int v1 = valStack.pop();
                    int v2 = valStack.pop();
                    int result = calc(op, v1, v2);
                    valStack.push(result);
                }

                opsStack.push(letter);
            } else if (")".equals(letter)) {
                while (!opsStack.isEmpty() && !"(".equals(opsStack.peek())) {
//                    if (opsStack.isEmpty()) continue;

                    String ops = opsStack.pop();
                    while (!opsStack.isEmpty() && ("(".equals(ops))) {
                        ops = opsStack.pop();
                    }

                    if (valStack.size() < 2) continue;

                    int val1 = valStack.pop();
                    int val2 = valStack.pop();
                    valStack.push(calc(ops, val1, val2));
                }

                if ("(".equals(opsStack.peek())) {
                    opsStack.pop();
                }
            } else {
                int start = i;
                while ((i < length) && "1234567890".contains(letter)) {
                    i++;
                    if (i > length - 1) break;

                    letter = opsStr[i];
                }

                letter = s.substring(start, i);
                valStack.push(Integer.parseInt(letter));
                i--;
            }
        }

        while (!opsStack.isEmpty()) {
            String op = opsStack.pop();
            while (!opsStack.isEmpty() && ("(".equals(op))) {
                op = opsStack.pop();
            }

            if (valStack.size() < 2) break;

            int v1 = valStack.pop();
            int v2 = valStack.pop();
            int result = calc(op, v1, v2);

            valStack.push(result);
        }

        return valStack.peek();
    }

    private int calc(String ops, int val1, int val2) {
        // int result = 0;
        switch (ops) {
            case "+":
                return val2 + val1;
            case "-":
                return val2 - val1;
            case "*":
                return val2 * val1;
            case "/":
                return val2 / val1;
            default:
                return 0;
        }
    }

    private Map<String, Integer> opsPriority() {
        Map<String, Integer> opsMap = new HashMap();
        opsMap.put("+", 1);
        opsMap.put("-", 1);
        opsMap.put("*", 2);
        opsMap.put("/", 2);
        opsMap.put("(", 3);
        opsMap.put(")", 3);

        return opsMap;
    }


    static String digitRegex = "^\\d*$";

    static void splitGroup(String content) {
        Pattern digitPattern = Pattern.compile(digitRegex);
        Matcher digitMatcher = digitPattern.matcher(content);
        String group0 = digitMatcher.group();

    }
}
