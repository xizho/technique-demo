package com.example.design.pattern.algorithms.datastructure.tree;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        TreeNode root = new TreeNode(1);

        binaryTree.setRoot(root);

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        root.setLeft(left);
        left.setLeft(new TreeNode(4));
        left.setRight(new TreeNode(5));

        root.setRight(right);
        right.setLeft(new TreeNode(6));
        right.setRight(new TreeNode(7));
        System.out.println("*********前序遍历********");
        // 前序遍历
        binaryTree.frontShow();
        System.out.println("*****************");
        System.out.println("*********中序遍历********");
        // 中序遍历
        binaryTree.midShow();
        System.out.println("*****************");
        System.out.println("*********后序遍历********");
        // 后序遍历
        binaryTree.afterShow();
        System.out.println("*****************");
        System.out.println("////////////////////");

        System.out.println("*********前序查找********");
        TreeNode result = binaryTree.fontSearch(5);
        System.out.println(result);
        System.out.println(result.getValue());

        System.out.println("*********删除********");
        binaryTree.delete(3);
        binaryTree.frontShow();
    }
}
