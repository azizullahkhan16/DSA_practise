package org.aktic.maximumTripletValue1;

public class Solution {
    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        prefixMax[0] = nums[0];
        for (int i = 1; i < prefixMax.length; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        suffixMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
        }

        long max = 0;
        for (int i = 1; i < n - 1; i++) {
            max = Math.max(max, (long) (prefixMax[i - 1] - nums[i]) * suffixMax[i + 1]);
        }

        return max;

    }
}
