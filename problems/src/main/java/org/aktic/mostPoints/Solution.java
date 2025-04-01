package org.aktic.mostPoints;

public class Solution {
    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1]; // DP array

        // Iterate from the last question to the first
        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];
            int nextIndex = i + brainpower + 1;

            // Option 1: Solve this question
            long solve = points + (nextIndex < n ? dp[nextIndex] : 0);

            // Option 2: Skip this question
            long skip = dp[i + 1];

            // Take the max of both options
            dp[i] = Math.max(solve, skip);
        }

        return dp[0]; // Maximum points starting from question 0
    }

    public static void main(String[] args) {
        System.out.println(mostPoints(new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}}));
    }
}
