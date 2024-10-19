package org.aktic.minCostClimbingStairs;

public class Solution {
    public static int minCostClimbingStairs(int[] cost) {
        if(cost.length < 3) return Math.min(cost[0], cost[1]);

        int[] dp = new int[cost.length+1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(cost[i-1]+dp[i-1], cost[i-2]+dp[i-2]);
        }

        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
