package org.aktic.gridGame;

public class Solution {
    public static long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] prefixTop = new long[n];
        long[] prefixBottom = new long[n];

        // Compute prefix sums for both rows
        prefixTop[0] = grid[0][0];
        prefixBottom[0] = grid[1][0];
        for (int i = 1; i < n; i++) {
            prefixTop[i] = prefixTop[i - 1] + grid[0][i];
            prefixBottom[i] = prefixBottom[i - 1] + grid[1][i];
        }

        long minSecondRobotScore = Long.MAX_VALUE;

        // Simulate the first robot's path and calculate the second robot's maximum score
        for (int i = 0; i < n; i++) {
            // Remaining sums for the second robot
            long topRemaining = (i == n - 1) ? 0 : prefixTop[n - 1] - prefixTop[i];
            long bottomRemaining = (i == 0) ? 0 : prefixBottom[i - 1];

            long secondRobotScore = Math.max(topRemaining, bottomRemaining);
            minSecondRobotScore = Math.min(minSecondRobotScore, secondRobotScore);
        }

        return minSecondRobotScore;
    }

    public static void main(String[] args) {
        System.out.println(gridGame(new int[][] {{2,5,4},
                {1,5,1}}));
    }
}
