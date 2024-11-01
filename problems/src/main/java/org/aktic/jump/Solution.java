package org.aktic.jump;

public class Solution {
//    public static int jump(int[] nums) {
//        if (nums.length == 1) return 0;
//        int[] dp = new int[nums.length];
//        dp[0] = 0;
//
//        for (int i = 0; i < nums.length-1; i++) {
//            if(nums[i] != 0) {
//                for (int j = i+1; j <= i+nums[i] && j < nums.length; j++) {
//                    if(dp[j] == 0) {
//                        dp[j] = 1 + dp[i];
//                    } else dp[j] = Math.min(dp[j], dp[i] + 1);
//                }
//            }
//        }
//
//        return dp[dp.length-1];
//    }

    public static int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int jumps = 0, currentEnd = 0, farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // When we reach the end of the range for the current jump
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }


    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }
}
