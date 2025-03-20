package org.aktic.minimumCost;

import java.util.Arrays;
import java.util.Comparator;

class UnionFind {
    private int[] parent, rank;
    private int[] minCost;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    public void union(int x, int y, int weight) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
                minCost[rootX] &= minCost[rootY] & weight;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
                minCost[rootY] &= minCost[rootX] & weight;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
                minCost[rootX] &= minCost[rootY] & weight;
            }
        } else {
            minCost[rootX] &= weight;
        }
    }

    public int getMinCost(int x) {
        return minCost[find(x)];
    }
}

public class Solution {
    public static int[] minimumCost(int n, int[][] edges, int[][] queries) {
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2])); // Sort edges by weight
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1], edge[2]);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0], t = queries[i][1];
            if (uf.find(s) == uf.find(t)) {
                result[i] = uf.getMinCost(s);
            } else {
                result[i] = -1;
            }
        }
        return result;
    }
}
