package org.aktic.orangesRotting;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int orangesRotting(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int freshCount = 0;
        int time = 0;

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all initially rotten oranges to the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (mat[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // If there are no fresh oranges
        if (freshCount == 0) return 0;

        // Direction vectors: up, down, left, right
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean anyRotThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int row = curr[0], col = curr[1];

                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newRow < rows &&
                            newCol >= 0 && newCol < cols &&
                            mat[newRow][newCol] == 1) {

                        mat[newRow][newCol] = 2;  // rot it
                        queue.offer(new int[]{newRow, newCol});
                        freshCount--;
                        anyRotThisMinute = true;
                    }
                }
            }

            if (anyRotThisMinute) time++;  // Only increment time if something rotted
        }

        return freshCount == 0 ? time : -1;
    }

}
