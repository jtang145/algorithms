package com.jtang.alg.search.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图,邻接表实现
 */
public class Graph1 {
    private int vertex;
    private LinkedList<Integer> adj[];

    public Graph1(int vertex) {
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


    public void bfs(int startNode, int toNode) {
        if (startNode == toNode) {
            return;
        }
        boolean[] visited = new boolean[vertex];
        visited[startNode] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        int[] prev = new int[vertex];
        for (int i = 0; i < vertex; i++) {
            prev[i] = -1;
        }

        while (queue.size() != 0) {
            int to_visit = queue.poll();
            //process a link list, all 
            for (int i =0; i<adj[to_visit].size(); i++){
                int q = adj[to_visit].get(i);
                if(!visited[q]){
                    prev[q] = to_visit;
                    if(q == toNode){
                        printResult(prev, startNode, toNode);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void printResult(int[] prev, int startNode, int toNode) {
        if(prev[toNode] != -1 && startNode != toNode){
            printResult(prev, startNode, prev[toNode]);
        }
        System.out.println(toNode + " ");
    }
}
