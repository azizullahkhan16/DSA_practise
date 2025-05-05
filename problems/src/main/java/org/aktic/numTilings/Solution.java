package org.aktic.numTilings;

public class Solution {
    public static int numTilings(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 2; i < n; i++) {
            dp[i + 1] = (int) (((2L * dp[i]) % MOD + dp[i - 2]) % MOD);
        }

        return dp[n];
    }

    public static void main(String[] args) {

    }
}
