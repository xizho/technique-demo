package com.example.design.pattern.algorithms.excel;

import java.util.ArrayList;
import java.util.List;

public class SortRefugee {

    public static void main(String[] args) {
        List<Refugee> list = new ArrayList<>();

        list.add(new Refugee("lilie", "male", 11, 20));
        list.add(new Refugee("hanmeimei", "female", 10, 126));
        list.add(new Refugee("zhanglaoshi", "male", 54, 100));
        list.add(new Refugee("lilaoshi", "female", 41, 150));
        list.add(new Refugee("xiaozhang", "female", 75, 155));
        list.add(new Refugee("laozhuren", "male", 55, 145));
        list.add(new Refugee("shenayi", "female", 19, 127));


    }

    static void sort(List<Refugee> list) {

    }

    static class Refugee {
        String name;
        String sex;
        int age;
        int point;

        public Refugee(String name, String sex, int age, int point) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.point = point;
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
