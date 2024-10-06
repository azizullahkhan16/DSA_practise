package org.aktic.minCostClimbingStairs;

public class Solution {
    public static int minCostClimbingStairs(int[] cost) {
        if(cost.length < 3) return 0;

        int[] dp = new int[cost.length];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(cost[i-1], cost[i-2]);
        }

        return Math.min(dp[cost.length-1], dp[cost.length-2]);
    }

    public static void main(String[] args) {
        int[] cost = {10,15,20};
        System.out.println(minCostClimbingStairs(cost));
    }
}
