package com.example.design.pattern.algorithms.datastructure.stack;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        String[] tokens = {"0", "3", "/"};
        evalRPN2(tokens);
    }

    static int evalRPN1(String[] tokens) {
        Stack<Integer> valueStack = new Stack<>();

        for (int i = 0, length = tokens.length; i < length; i++) {
            String val = tokens[i];
            switch (val) {
                case "+": {
                    int v1 = valueStack.pop();
                    int v2 = valueStack.pop();
                    valueStack.push(v2 + v1);
                    break;
                }
                case "-": {
                    int v1 = valueStack.pop();
                    int v2 = valueStack.pop();
                    valueStack.push(v2 - v1);
                    break;
                }
                case "*": {
                    int v1 = valueStack.pop();
                    int v2 = valueStack.pop();
                    valueStack.push(v2 * v1);
                    break;
                }
                case "/": {
                    int v1 = valueStack.pop();
                    int v2 = valueStack.pop();

                    valueStack.push(v2 / v1);
                    break;
                }
                default:
                    valueStack.push(Integer.valueOf(val));
            }
        }

        return valueStack.pop();
    }

    static int evalRPN2(String[] tokens) {

        Stack<Integer> stack = new Stack<Integer>();
        int num1 = 0, num2 = 0;
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("+")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 + num1);
            } else if (s.equals("-")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 - num1);
            } else if (s.equals("*")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 * num1);
            } else if (s.equals("/")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 / num1);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();

    }
}
