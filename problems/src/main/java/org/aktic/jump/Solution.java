package org.aktic.jump;

public class Solution {
    public static int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 0;

        int min = 1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]+i < nums.length-1) {
                for (int j = i+1; j <= nums[i]+i; j++) {
                    if(dp[j] == 0) dp[j] = 1;
                    else dp[j] += 1;
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 2, 1, 1, 4}));
    }
}
