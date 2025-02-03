package org.aktic.longestMonotonicSubarray;

public class Solution {
    public static int longestMonotonicSubarray(int[] nums) {
        int max = 1;

        int increase = 1;
        int decrease = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                increase++;
                decrease = 1;
            } else if (nums[i] < nums[i - 1]) {
                decrease++;
                increase = 1;
            } else {
                increase = 1;
                decrease = 1;
            }

            max = Math.max(max, Math.max(increase, decrease));
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestMonotonicSubarray(new int[]{3, 2, 1}));
    }
}
