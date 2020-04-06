package com.example.design.pattern.algorithms.datastructure.graph;

import com.example.design.pattern.algorithms.datastructure.stack.MyStack;

/**
 * 定义一个图
 */
public class Graph {

    /**
     * 顶点
     */
    private Vertex[] vertices;

    /**
     * 当前下标
     */
    private int currentIndex;

    private int currentInquireIndex;

    /**
     * 二维数组存放顶点间的连通关系
     */
    private int[][] adjMat;

    private MyStack stack = new MyStack();


    public Graph(Vertex[] vertices) {
        this.vertices = vertices;
    }


    public Graph(int size) {
        vertices = new Vertex[size];
        adjMat = new int[size][size];
        // 自身是连通的
        for (int i = 0; i < size; i++) {
            adjMat[i][i] = 1;
        }
    }

    /**
     * 添加顶点
     *
     * @param vertex
     */
    public void addVertex(Vertex vertex) {
        vertices[currentIndex++] = vertex;
    }

    /**
     * 设置两个顶点间的连通关系
     *
     * @param v1
     * @param v2
     */
    public void addEdge(String v1, String v2) {
        int index1 = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].getValue().equals(v1)) {
                index1 = i;
                break;
            }
        }

        int index2 = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].getValue().equals(v2)) {
                index2 = i;
                break;
            }
        }

        // v1和v2是互相连通的
        adjMat[index1][index2] = 1;
        adjMat[index2][index1] = 1;
    }


    /**
     * 深度优先遍历
     */
    public void dfs() {
        // 从第0个开始访问，并标记为已访问
        vertices[0].setVisited(true);
        stack.push2(0);

        // 打印值
        System.out.println(vertices[0].getValue());

        // 遍历
        nextLoop:
        while (!stack.empty()) {
            // 当前值开始依此往后遍历，寻找相通的顶点
            for (int i = currentInquireIndex + 1; i < vertices.length; i++) {
                // 如果相通，且没有访问过，则压入栈中，并标记为已访问，并跳入下次循环
                if (adjMat[currentInquireIndex][i] == 1 && !vertices[i].isVisited()) {
                    stack.push2(i);
                    vertices[i].setVisited(true);
                    System.out.println(vertices[i].getValue());

                    continue nextLoop;
                }
            }

            // 若无相通且未访问的顶点，则弹出栈顶元素
            stack.pop2();
            if (!stack.empty()) {
                // 将当前栈顶元素赋值给当前遍历索引
                currentInquireIndex = stack.peek();
            }
        }

    }


    public int[][] getAdjMat() {
        return adjMat;
    }
}
