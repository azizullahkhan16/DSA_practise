package org.aktic.buildArray;

public class Solution {
    public static int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[nums[i]];
        }

        return res;
    }

}
