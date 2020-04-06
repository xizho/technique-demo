package com.example.design.pattern.algorithms.datastructure.tree;

/**
 * 顺序二叉树：二叉树结构的数组
 */
public class ArrayBinaryTree {

    int[] data;

    public ArrayBinaryTree(int[] data) {
        this.data = data;
    }

    public void frontShow() {
        frontShow(0);
    }

    /**
     * 前序遍历
     *
     * @param index
     */
    public void frontShow(int index) {
        if (data == null || data.length == 0) {
            return;
        }

        System.out.println(data[index]);

        // 第index元素的左子节点位置为：2 * index + 1
        int left = 2 * index + 1;
        if (left < data.length) {
            frontShow(left);
        }

        // 第index元素的右子节点位置为：2 * index + 2
        int right = 2 * index + 2;
        if (right < data.length) {
            frontShow(right);
        }
    }

}
