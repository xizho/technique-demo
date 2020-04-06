package com.example.design.pattern.algorithms.datastructure.tree;

import lombok.Data;

@Data
public class HuffmanTreeNode implements Comparable<HuffmanTreeNode> {

    private int value;

    private HuffmanTreeNode left;

    private HuffmanTreeNode right;

    public HuffmanTreeNode(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(HuffmanTreeNode o) {
        return (this.value - o.value);
    }
}
