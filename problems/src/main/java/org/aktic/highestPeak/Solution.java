package org.aktic.highestPeak;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Initialize queue with all water cells (height = 0)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    res[i][j] = 0;
                    queue.offer(new int[]{i, j}); // Add water cells to queue
                } else {
                    res[i][j] = -1; // Mark land as unvisited
                }
            }
        }

        // BFS traversal
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];

            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && res[x][y] == -1) {
                    res[x][y] = res[i][j] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
