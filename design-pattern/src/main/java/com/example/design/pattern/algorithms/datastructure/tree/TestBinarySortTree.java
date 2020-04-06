package com.example.design.pattern.algorithms.datastructure.tree;

public class TestBinarySortTree {
    public static void main(String[] args) {
        int[] arr = {7, 3, 5, 10, 12, 1, 9};

        BinarySortTree bst = new BinarySortTree();
        for (int i : arr) {
            bst.add(new BinarySortTreeNode(i));
        }

//        bst.midShow();

        System.out.println();

//        System.out.println(bst.search(10).value);
//        System.out.println(bst.search(11).value);

        System.out.println("*************************");
//        bst.delete(1);
//        bst.delete(12);

//        bst.delete(7);
//        bst.midShow();


//        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr2 = {2, 1, 4, 3, 5, 6};
        BinarySortTree bst2 = new BinarySortTree();
        for (int i : arr2) {
            bst2.add(new BinarySortTreeNode(i));
        }
        System.out.println(bst2.root.height());
    }
}
