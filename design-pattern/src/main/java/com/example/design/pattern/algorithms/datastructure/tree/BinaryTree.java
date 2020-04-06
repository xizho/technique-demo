package com.example.design.pattern.algorithms.datastructure.tree;

public class BinaryTree {

    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
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

    public TreeNode fontSearch(int i) {
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
