package com.example.design.pattern.algorithms.datastructure.graph;

/**
 * 顶点类
 */
public class Vertex {

    private String value;

    private boolean visited;

    public Vertex(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
