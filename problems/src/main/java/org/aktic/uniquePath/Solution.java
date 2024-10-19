package org.aktic.uniquePath;

public class Solution {
    public static int uniquePaths(int m, int n) {
        if(m == 1 && n == 1) return 1;
        else if(m == 2 && n == 2) return 2;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] += dp[i][j-1] + dp[i-1][j];

            }
        }

        return dp[m-1][n-1];
    }


    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
    }
}
