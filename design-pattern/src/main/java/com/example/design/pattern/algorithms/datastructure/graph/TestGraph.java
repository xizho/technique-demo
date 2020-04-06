package com.example.design.pattern.algorithms.datastructure.graph;

import java.util.Arrays;

public class TestGraph {

    public static void main(String[] args) {
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");

        Graph graph = new Graph(5);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        graph.addEdge(v1.getValue(), v3.getValue());
        graph.addEdge(v2.getValue(), v3.getValue());
        graph.addEdge(v1.getValue(), v2.getValue());
        graph.addEdge(v2.getValue(), v4.getValue());
        graph.addEdge(v2.getValue(), v5.getValue());

        /**   A  B  C  D  E
         * A  1, 1, 1, 0, 0
         * B  1, 1, 1, 1, 1
         * C  1, 1, 1, 0, 0
         * D  0, 1, 0, 1, 0
         * E  0, 1, 0, 0, 1
         */
        for (int[] arr : graph.getAdjMat()) {
            System.out.println(Arrays.toString(arr));
        }

        // 深度遍历
        graph.dfs();
    }
}
