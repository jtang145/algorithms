package com.jtang.alg.search.graph.dfs;

public class Graph2Test {
    public static void main(String[] args){
        DFSGraph graph1 = new DFSGraph(8);
        graph1.addEdge(0,1);
        graph1.addEdge(0,3);
        graph1.addEdge(4,3);
        graph1.addEdge(1,4);
        graph1.addEdge(1,2);
        graph1.addEdge(5,2);
        graph1.addEdge(5,4);
        graph1.addEdge(6,4);
        graph1.addEdge(6,7);
        graph1.addEdge(5,7);

        graph1.printGraph();
        graph1.dfs(0,7);
    }
}
