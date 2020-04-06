package com.example.design.pattern.algorithms.datastructure.tree;

public class TestArrayBinaryTree {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(data);
        arrayBinaryTree.frontShow(3);
    }
}
