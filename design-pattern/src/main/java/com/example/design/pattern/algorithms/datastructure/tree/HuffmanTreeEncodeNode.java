package com.example.design.pattern.algorithms.datastructure.tree;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HuffmanTreeEncodeNode implements Comparable<HuffmanTreeEncodeNode> {

    private int weight;

    private Byte data;

    private HuffmanTreeEncodeNode left;

    private HuffmanTreeEncodeNode right;

    public HuffmanTreeEncodeNode(Byte data, int weight) {
        this.weight = weight;
        this.data = data;
    }

    @Override
    public int compareTo(HuffmanTreeEncodeNode o) {
        return (this.weight - o.weight);
    }
}
