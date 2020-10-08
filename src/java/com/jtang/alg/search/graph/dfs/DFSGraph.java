package com.jtang.alg.search.graph.dfs;

import com.jtang.alg.search.graph.BaseGraph;

/**
 * 相比广度优先，它的路径不是最短。
 */
public class DFSGraph extends BaseGraph {
    private boolean found = false;

    public DFSGraph(int vertex) {
        super(vertex);
        this.found = false;
    }

    public void dfs(int start, int end) {
        found = false;
        boolean[] visited = new boolean[vertex];
        int[] prev = new int[vertex];
        for (int i = 0; i < vertex; i++) {
            prev[i] = -1;
        }
        recurDfs(start, end, visited, prev);
        printResult(prev, start, end);
    }

    private void recurDfs(int start, int end, boolean[] visited, int[] prev) {
        if (found) {
            return;
        }
        visited[start] = true;
        if (start == end) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[start].size(); ++i) {
            int q = adj[start].get(i);
            if (!visited[q]) {
                prev[q] = start;
                recurDfs(q, end, visited, prev);
            } else {
                System.out.println("skip visited node:" + q);
            }
        }
    }


}
