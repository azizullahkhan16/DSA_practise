package org.aktic.findLHS;

import java.util.Arrays;

public class Solution {
    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int max = 0;

        for (int i = 1; i < nums.length; i++) {
            while (nums[i] - nums[left] > 1) {
                left++;

            }
            if (nums[i] - nums[left] == 1)
                max = Math.max(max, i - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1, 2, 2, 1}));
    }
}
