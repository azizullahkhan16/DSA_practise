package org.aktic.maxAdjacentDistance;

public class Solution {
    public static int maxAdjacentDistance(int[] nums) {
        int maxDiff = 0;

        for (int i = 1; i < nums.length; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(nums[i] - nums[i - 1]));
        }

        return Math.max(maxDiff, Math.abs(nums[0] - nums[nums.length - 1]));
    }

    public static void main(String[] args) {
        System.out.println(maxAdjacentDistance(new int[]{1, 2, 4}));
    }
}
