package org.aktic.gridGame;

public class Solution {
    public long gridGame(int[][] grid) {
        long row1Sum = 0;
        long row2Sum = 0;

        for(int i = 0; i < grid[0].length; i++) {
            row1Sum += grid[0][i];
            row2Sum += grid[1][i];
        }
    }
}
