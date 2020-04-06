package com.example.other.test.other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        for (String s : list) {
            if ("C".equals(s)) {
                list.remove(s);
            }
        }

        System.out.println(list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if ("C".equals(iterator.next())) {
                iterator.remove();
            }
        }

        System.out.println(list);
    }
}
