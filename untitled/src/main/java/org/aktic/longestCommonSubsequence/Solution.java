package org.aktic.longestCommonSubsequence;

public class Solution {
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        dp[0][0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[dp.length-1][dp[0].length-1];

    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("a", "n"));
    }
}
