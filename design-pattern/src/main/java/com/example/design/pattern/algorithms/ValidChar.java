package com.example.design.pattern.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidChar {

    public static boolean isValid(String s) {
        char[] cArr = s.toCharArray();
        Map charMap = new HashMap();
        charMap.put(')', '(');
        charMap.put(']', '[');
        charMap.put('}', '{');

        Stack charStack = new Stack();
        for (int i = 0, length = cArr.length; i < length; i++) {
            if (cArr[i] == '(' || cArr[i] == '[' || cArr[i] == '{') {
                charStack.push(cArr[i]);
            } else if (cArr[i] == ')' || cArr[i] == ']' || cArr[i] == '}') {
                if (charStack.isEmpty() || charStack.pop().equals(charMap.get(cArr[i]))) {
                    return false;
                }
            }
        }

        return charStack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(]";
        System.out.println(isValid(s));
    }
}
