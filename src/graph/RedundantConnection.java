package graph;

// https://leetcode.com/problems/redundant-connection/?envType=daily-question&envId=2025-01-29
// union find
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] uf = new int[edges.length + 1];

        for (int[] edge : edges) {
            int idx1 = find(uf, edge[0]);
            int idx2 = find(uf, edge[1]);
            if (idx1 == idx2) {
                return edge;
            }
            uf[idx1] = idx2;
        }
        return edges[edges.length - 1];
    }

    int find(int[] uf, int node) {
        if (uf[node] == 0) {
            return node;
        }
        return find(uf, uf[node]);
    }
}
