package org.aktic.uniquePathsWithObstacles;

public class Solution {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                else if(i > 0 && j > 0) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                else if(i > 0) dp[i][j] = dp[i - 1][j];
                else if(j > 0) dp[i][j] = dp[i][j - 1];

            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,1,0,0,0}, {1,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
