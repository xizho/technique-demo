package com.example.other.test.other;

import java.util.ArrayList;

public class Lesson5_1 {

    public static long[] rewards = {1, 2, 5, 10};    // 四种面额的纸币

    /**
     * @param totalReward- 奖赏总金额，result- 保存当前的解
     * @return void
     * @Description: 使用函数的递归（嵌套）调用，找出所有可能的奖赏组合
     */

    public static void get(long totalReward, ArrayList<Long> result) {

        // 当 totalReward = 0 时，证明它是满足条件的解，结束嵌套调用，输出解
        if (totalReward == 0) {
            System.out.println(result);
            return;
        }
        // 当 totalReward < 0 时，证明它不是满足条件的解，不输出
        else if (totalReward < 0) {
            return;
        } else {
            for (int i = 0; i < rewards.length; i++) {
                ArrayList<Long> resultList = (ArrayList<Long>) (result.clone());   // 由于有 4 种情况，需要 clone 当前的解并传入被调用的函数
                resultList.add(rewards[i]);                                        // 记录当前的选择，解决一点问题
                get(totalReward - rewards[i], resultList);               // 剩下的问题，留给嵌套调用去解决
            }
        }
    }

    private static ArrayList<Long> resultList = new ArrayList<>();

    public static void main(String[] args) {
//        get(10L, new ArrayList<>());
        get(10L, resultList);
    }

}
