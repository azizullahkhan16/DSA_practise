package org.aktic.subsetXORSum;

public class Solution {
    public static int subsetXORSum(int[] nums) {
        return backTrack(nums, 0, 0);
    }

    public static int backTrack(int[] nums, int index, int xor) {
        if (index == nums.length) {
            return xor;
        }

        int include = backTrack(nums, index + 1, xor ^ nums[index]);

        int exclude = backTrack(nums, index + 1, xor);

        return include + exclude;
    }
}
