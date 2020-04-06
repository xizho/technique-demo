package com.example.other.test.other;

import java.util.ArrayList;

/**
 * @author zhong
 */
public class ProgrammerMath {

    public static void main(String[] args) {
        recursive();
    }

    /**
     * 递归思维
     */
    static void recursive() {
        int number = 8;
        multiplier(number, new ArrayList<Integer>());
//        recursion(number, new ArrayList<>());
    }


    private static void multiplier(int number, ArrayList<Integer> resultList) {
        if (number == 1) {
            System.out.println(resultList);
            return;
        }

        for (int i = 1; i <= number; i++) {
            if (number % i != 0) continue;
            if ((i == 1) && resultList.contains(1)) continue;

            ArrayList<Integer> tempList = (ArrayList<Integer>) resultList.clone();
            tempList.add(i);

            multiplier(number / i, tempList);
        }

    }

    public static void recursion(long total, ArrayList<Long> result) {

        if (total == 1) {
            if (!result.contains(1L)) result.add(1L);
            System.out.println(result);
            return;
        } else {
            for (long i = 1; i <= total; i++) {
                if ((i == 1) && result.contains(1L)) continue;

                ArrayList<Long> newList = (ArrayList<Long>) (result.clone());
                newList.add(Long.valueOf(i));
                if (total % i != 0) {
                    continue;
                }
                recursion(total / i, newList);
            }
        }
    }

}
