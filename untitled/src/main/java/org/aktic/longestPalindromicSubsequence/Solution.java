package org.aktic.longestPalindromicSubsequence;

public class Solution {

    public static int longestPalindromicSubsequence(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base case: single characters are palindromes of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill the table for substrings of length 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        // The answer is in dp[0][n-1], the LPS length for the whole string
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "ACGTGTCAAAATCG";
        System.out.println("Length of the Longest Palindromic Subsequence: " + longestPalindromicSubsequence(s));  // Output: 7
    }
}
