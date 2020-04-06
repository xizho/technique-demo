package com.example.design.pattern.algorithms.datastructure.tree;

import java.util.*;

public class TestHuffmanTree {

    public static void main(String[] args) {
        int[] arr = {3, 7, 8, 29, 5, 11, 23, 14};

        HuffmanTreeNode node = createHuffmanTree(arr);

        System.out.println(node);
    }

    private static HuffmanTreeNode createHuffmanTree(int[] arr) {
        List<HuffmanTreeNode> huffmanTreeNodeList = new ArrayList<>();

        Arrays.stream(arr).forEach(value -> huffmanTreeNodeList.add(new HuffmanTreeNode(value)));

        while (huffmanTreeNodeList.size() > 1) {
            // 排序
            Collections.sort(huffmanTreeNodeList);
            System.out.println(huffmanTreeNodeList);
            // 取出最小的两个节点
            HuffmanTreeNode left = huffmanTreeNodeList.get(0);
            HuffmanTreeNode right = huffmanTreeNodeList.get(1);
            // 根据最小的两个节点，组成一个新的节点
            HuffmanTreeNode parent = new HuffmanTreeNode(left.getValue() + right.getValue());
            // 移除最小的两个节点
            huffmanTreeNodeList.remove(left);
            huffmanTreeNodeList.remove(right);
            // 将新节点增加到原集合中
            huffmanTreeNodeList.add(parent);
        }

        return huffmanTreeNodeList.get(0);
    }
}
