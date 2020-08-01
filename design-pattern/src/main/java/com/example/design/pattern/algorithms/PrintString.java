package com.example.design.pattern.algorithms;

import java.util.Stack;

/**
 * abccdeeccf -> abcdecf
 * @author xizho
 */
public class PrintString {
    public static void main(String[] args) {
        String str = "abccdeeccf";
        System.out.println("原始字符串：" + str);
        System.out.println("结果字符串：" + convert(str));
    }

    static String convert(String str) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            // 此处需要判断当前元素和栈顶元素是否相同，如果相同，不压栈
            if (!stack1.isEmpty() && (stack1.peek() == str.charAt(i))) continue;

            // 将元素压入栈中
            stack1.push(str.charAt(i));
        }
        System.out.println(stack1);

        // 此处的用途是为了输出字符时，按原顺序输出
        while (!stack1.isEmpty()) stack2.push(stack1.pop());

        char[] newChar = new char[stack2.size()];
        for (int i = 0; i < newChar.length; i++) {
            newChar[i] = stack2.pop();
        }

        return new String(newChar);
    }

}
