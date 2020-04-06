package com.example.design.pattern.algorithms.datastructure.tree;

public class TestThreadedBinaryTree {
    public static void main(String[] args) {
        ThreadedBinaryTree binaryTree = new ThreadedBinaryTree();

        ThreadedNode root = new ThreadedNode(1);

        binaryTree.setRoot(root);

        ThreadedNode left = new ThreadedNode(2);
        root.setLeft(left);
        left.setLeft(new ThreadedNode(4));
        ThreadedNode node5 = new ThreadedNode(5);
        left.setRight(node5);

        ThreadedNode right = new ThreadedNode(3);
        root.setRight(right);
        right.setLeft(new ThreadedNode(6));
        right.setRight(new ThreadedNode(7));

        System.out.println("*********转化为线索二叉树********");
        binaryTree.midShow();
        binaryTree.threadNode();
//        binaryTree.midShow();

        ThreadedNode after5Node = node5.getRight();
        System.out.println("5节点的后继节点是：" + after5Node.getValue());

        binaryTree.threadedIterator();
    }
}
