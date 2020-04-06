package com.example.design.pattern.algorithms.datastructure.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * 计算器：
 */
public class DoubleStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入：");
            String exp = scanner.nextLine();
//        exp = "(1+((2+3)*(4*5)))";
            int result = evaluate(exp);
            System.out.println("结果：" + result);
            System.out.println("****************************");
        }
    }


    /**
     * 只能进行个位数的加减乘除
     *
     * @param exp
     * @return
     */
    static int evaluate(String exp) {
        Stack<Character> ops = new Stack<>();
        Stack<Integer> val = new Stack<>();
        Map<Character, Integer> opsPriorityMap = opsPriority();
        char[] opsCharArr = exp.toCharArray();
        for (int i = 0; i < opsCharArr.length; i++) {
            char letter = opsCharArr[i];
            if (letter == '(') {
                ops.push(letter);
            } else if (letter == '+' || letter == '-' || letter == '*' || letter == '/') {
                char stackTop;
                if (!ops.isEmpty() && !('(' == (stackTop = ops.peek()))
                        && (opsPriorityMap.get(letter) <= opsPriorityMap.get(stackTop))) {
                    char op = ops.pop();
                    int v1 = val.pop();
                    int v2 = val.pop();
                    int result = calculate(op, v1, v2);
                    val.push(result);
                }

                ops.push(letter);
            } else if (letter == ')') {
                char op = ops.pop();
                int v1 = val.pop();
                int v2 = val.pop();
                int result = calculate(op, v1, v2);
                val.push(result);
            } else {
                val.push(Integer.valueOf(letter + ""));
            }
        }

        while (!ops.isEmpty()) {
            char op = ops.pop();
            while (!ops.isEmpty() && ('(' == op)) {
                op = ops.pop();
            }

            if (val.size() < 2) break;

            int v1 = val.pop();
            int v2 = val.pop();
            int result = calculate(op, v1, v2);

            val.push(result);
        }

        return val.pop();
    }

    static int calculate(char op, int v1, int v2) {
        int result = 0;
        if (op == '+') {
            result = v2 + v1;
        } else if (op == '-') {
            result = v2 - v1;
        } else if (op == '*') {
            result = v2 * v1;
        } else if (op == '/') {
            result = v2 / v1;
        }

        return result;
    }

    private static Map<Character, Integer> opsPriority() {
        Map<Character, Integer> opsMap = new HashMap();
        opsMap.put('+', 1);
        opsMap.put('-', 1);
        opsMap.put('*', 2);
        opsMap.put('/', 2);
        opsMap.put('(', 3);
        opsMap.put(')', 3);

        return opsMap;
    }


    public int calculate(String s) {
        Stack<Integer> valStack = new Stack<>();
        Stack<String> opsStack = new Stack<>();

        char[] opsChar = s.toCharArray();
        String[] opsStr = new String[opsChar.length];
        for (int i = 0; i < opsChar.length; i++) {
            opsStr[i] = opsChar[i] + "";
        }

        for (int i = 0, length = opsStr.length; i < length; i++) {
            String letter = opsStr[i];
            if ("(".equals(letter) || " ".equals(letter)) {
                continue;
            } else if ("+-*/".contains(letter)) {
                opsStack.push(letter);
            } else if (")".equals(letter)) {
                if (opsStack.isEmpty()) break;

                String ops = opsStack.pop();
                int val1 = valStack.pop();
                int val2 = valStack.pop();
                valStack.push(calc(ops, val1, val2));
            } else {
                valStack.push(Integer.parseInt(letter));
            }
        }

        while (!opsStack.isEmpty()) {
            String ops = opsStack.pop();
            int val1 = valStack.pop();
            int val2 = valStack.pop();
            valStack.push(calc(ops, val1, val2));
        }

        return valStack.peek();
    }

    private int calc(String ops, int val1, int val2) {
        // int result = 0;
        switch (ops) {
            case "+":
                return val1 + val2;
            case "-":
                return val1 - val2;
            case "*":
                return val1 * val2;
            case "/":
                return val1 / val2;
            default:
                return 0;
        }
    }
}
