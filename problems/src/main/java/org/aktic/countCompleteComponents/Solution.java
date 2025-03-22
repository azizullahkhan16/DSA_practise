package org.aktic.countCompleteComponents;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        boolean[] visited = new boolean[n];
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, graph, visited, component);
                components.add(component);
            }
        }


        return components.size();
    }

    public static void dfs(int node, List<List<Integer>> graph, boolean[] visisted, List<Integer> component) {
        visisted[node] = true;
        component.add(node);

        for (int neighbor : graph.get(node)) {
            if (!visisted[neighbor]) {
                dfs(neighbor, graph, visisted, component);
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(countCompleteComponents(6, new int[][]{{0, 1}, {0, 2}, {1, 2}, {3, 4}}));
    }
}
