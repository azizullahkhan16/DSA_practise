package org.aktic.maximumDifference;

public class Solution {
    public static int maximumDifference(int[] nums) {
        int maxDiff = -1;

        int min = Integer.MAX_VALUE, max = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
                max = Integer.MAX_VALUE;
            } else {
                max = nums[i];
            }

            if (min != Integer.MAX_VALUE && max != Integer.MAX_VALUE) {
                maxDiff = Math.max(maxDiff, max - min);
            }


        }
        return maxDiff;
    }

    public static void main(String[] args) {
        System.out.println(maximumDifference(new int[]{9, 4, 3, 2}));
    }
}
