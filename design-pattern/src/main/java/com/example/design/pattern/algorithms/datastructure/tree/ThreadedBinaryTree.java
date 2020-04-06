package com.example.design.pattern.algorithms.datastructure.tree;

public class ThreadedBinaryTree {

    private ThreadedNode root;

    private ThreadedNode pre = null;
    private ThreadedNode after = null;

    public void setRoot(ThreadedNode root) {
        this.root = root;
    }

    public ThreadedNode getRoot() {
        return root;
    }

    public void threadNode() {
        threadNode(root);
    }

    /**
     * 中序法转化为线索二叉树
     *
     * @param node
     */
    public void threadNode(ThreadedNode node) {
        if (node == null) {
            return;
        }
        // 左子树
        threadNode(node.getLeft());
        // 处理前驱节点左指针
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        // 处理前驱节点右指针
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        // 置当前节点为下一个节点的前驱节点
        pre = node;
        // 本身

        // 右子树
        threadNode(node.getRight());
    }

    /**
     * 遍历线索二叉树
     */
    public void threadedIterator() {
        ThreadedNode node = root;
        while (node != null) {
            // 找到第一个节点，
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }

            // 打印当前值
            System.out.println(node.getValue());

            // 处理后继节点
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node.getValue());
            }

            // 遍历root的右子树
            node = node.getRight();
        }
    }

    public void frontShow() {
        if (root != null) {
            root.frontShow();
        }
    }

    public void midShow() {
        if (root != null) {
            root.midShow();
        }
    }

    public void afterShow() {
        if (root != null) {
            root.afterShow();
        }
    }

    public ThreadedNode fontSearch(int i) {
        return root.fontSearch(i);
    }

    public void delete(int i) {
        if (root.getValue() == i) {
            root = null;
        } else {
            root.delete(i);
        }
    }
}
