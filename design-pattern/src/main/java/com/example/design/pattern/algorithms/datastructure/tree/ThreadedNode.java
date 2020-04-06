package com.example.design.pattern.algorithms.datastructure.tree;

public class ThreadedNode {

    private int value;

    private ThreadedNode left;

    private ThreadedNode right;

    // 标识指针类型：
    private int leftType;

    private int rightType;

    public ThreadedNode(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public ThreadedNode getLeft() {
        return left;
    }

    public ThreadedNode getRight() {
        return right;
    }

    public void setLeft(ThreadedNode left) {
        this.left = left;
    }

    public void setRight(ThreadedNode right) {
        this.right = right;
    }

    public void threadNode() {

    }

    public void threadNode(ThreadedNode node) {

    }

    /**
     * 前序遍历
     */
    public void frontShow() {
        System.out.println(value);
        if (left != null) {
            left.frontShow();
        }

        if (right != null) {
            right.frontShow();
        }
    }

    public void midShow() {
        if (left != null) {
            left.midShow();
        }
        System.out.println(value);
        if (right != null) {
            right.midShow();
        }
    }

    public void afterShow() {
        if (left != null) {
            left.afterShow();
        }
        if (right != null) {
            right.afterShow();
        }
        System.out.println(value);
    }

    /**
     * 前序查找
     *
     * @param i
     * @return
     */
    public ThreadedNode fontSearch(int i) {
        ThreadedNode target = null;
        if (this.value == i) {
            return this;
        } else {
            if (left != null) {
                target = left.fontSearch(i);
            }

            //  此处判断的作用是针对上一步递归返回结果的
            if (target != null) {
                return target;
            }

            if (right != null) {
                target = right.fontSearch(i);
            }
        }

        return target;
    }

    public int getValue() {
        return value;
    }

    public void delete(int i) {
        ThreadedNode parent = this;
        if (parent.left != null && parent.left.getValue() == i) {
            parent.left = null;
            return;
        }

        if (parent.right != null && parent.right.getValue() == i) {
            parent.right = null;
            return;
        }

        parent = left;
        if (parent != null) {
            parent.delete(i);
        }

        parent = right;
        if (parent != null) {
            parent.delete(i);
        }
    }
}
