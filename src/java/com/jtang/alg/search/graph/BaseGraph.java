package com.jtang.alg.search.graph;

import java.util.LinkedList;

/**
 * 图的邻接表实现
 */
public class BaseGraph {
    protected int vertex;
    protected LinkedList<Integer> adj[];

    public BaseGraph(int vertex) {
        this.vertex = vertex;
        adj = new LinkedList[vertex];
        for (int i = 0; i < vertex; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    public void printGraph() {
        System.out.println("Current Graph:");
        for (int i = 0; i < adj.length; i++) {
            System.out.println("Node: " + i);
            for(int j=0; j < adj[i].size(); j++){
                System.out.print(adj[i].get(j) + ", ");
            }
            System.out.println("");
        }
        System.out.println("-- print end --");
    }

    public void printResult(int[] prev, int startNode, int toNode) {
        if (prev[toNode] != -1 && startNode != toNode) {
            printResult(prev, startNode, prev[toNode]);
        }
        System.out.println(toNode + " ");
    }
}
