package org.aktic.numIslands;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public static int numIslands(char[][] grid) {
        Set<String> visited = new HashSet<>();
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited.contains(i + "," + j)) {
                    bfs(grid, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private static void bfs(char[][] grid, int row, int col, Set<String> visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited.add(row + "," + col);

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length
                        && grid[newR][newC] == '1'
                        && !visited.contains(newR + "," + newC)) {
                    queue.add(new int[]{newR, newC});
                    visited.add(newR + "," + newC);
                }
            }
        }
    }

}
