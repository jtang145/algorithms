package com.jtang.alg.search.graph.bfs;

public class Graph1Test {
    public static void main(String[] args){
        BFSGraph graph1 = new BFSGraph(8);
        graph1.addEdge(0,1);
        graph1.addEdge(0,3);
        graph1.addEdge(4,3);
        graph1.addEdge(1,2);
        graph1.addEdge(5,2);
        graph1.addEdge(1,4);
        graph1.addEdge(5,4);
        graph1.addEdge(6,4);
        graph1.addEdge(6,7);
        graph1.addEdge(5,7);

        graph1.printGraph();
        graph1.bfs(0,7);
    }
}
