package org.aktic.minimumArea;

public class Solution {
    public static int minimumArea(int[][] grid) {
        int minX = grid.length, minY = grid[0].length, maxX = 0, maxY = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    minX = Math.min(minX, j);
                    maxX = Math.max(maxX, j);
                    minY = Math.min(minY, i);
                    maxY = Math.max(maxY, i);

                }
            }
        }

        return (maxX - minX + 1) * (maxY - minY + 1);
    }

    public static void main(String[] args) {
        System.out.println(minimumArea(new int[][]{{0, 1, 0}, {1, 0, 1}}));
    }
}
