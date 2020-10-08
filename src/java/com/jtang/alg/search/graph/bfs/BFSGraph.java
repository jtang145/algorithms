package com.jtang.alg.search.graph.bfs;

import com.jtang.alg.search.graph.BaseGraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图,邻接表实现，实现特点：
 * 结果与链接表的初始存储顺序有关，
 *
 */
public class BFSGraph extends BaseGraph {


    public BFSGraph(int vertex) {
        super(vertex);
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
            //process a link list, all of them, that is breadth-first
            for (int i = 0; i < adj[to_visit].size(); i++) {
                int q = adj[to_visit].get(i);
                if (!visited[q]) {
                    prev[q] = to_visit;
                    if (q == toNode) {
                        printResult(prev, startNode, toNode);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

}
