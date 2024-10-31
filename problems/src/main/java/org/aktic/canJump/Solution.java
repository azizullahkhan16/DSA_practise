package org.aktic.canJump;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        boolean canJump;

        for (int i = 0; i < nums.length; i++) {
            canJump = false;
            if(nums[i] != 0) {
                dp[i] = i+nums[i];
            } else if(nums[i] == 0 && i != nums.length - 1) {
                for (int j = 0; j < dp.length; j++) {
                    if(dp[j] > i) {
                        canJump = true;
                        break;
                    }
                }
                if(!canJump) return false;

            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,0,1,0,1}));
    }
}
