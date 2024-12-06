package org.aktic.rob1;

public class Solution {
    public static int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        if(nums.length == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < dp.length-1; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        int[] dp2 = new int[nums.length];
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);

        for (int i = 3; i < dp2.length; i++) {
            dp2[i] = Math.max(dp2[i-2] + nums[i], dp2[i-1]);
        }

        return Math.max(dp2[dp2.length-1], dp[dp.length-2]);

    }


    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
}
