package org.aktic.minZeroArray;

public class Solution {
    public static int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];  // Difference array
        int nonZeroCount = 0;

        // Count non-zero elements initially
        for (int num : nums) {
            if (num > 0) nonZeroCount++;
        }
        if (nonZeroCount == 0) return 0;

        // Process queries
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int val = queries[i][2];

            diff[start] -= val;
            diff[end + 1] += val;

            // Apply difference array & update non-zero count
            int current = 0;
            for (int j = 0; j < n; j++) {
                current += diff[j];
                nums[j] += current;

                // Adjust non-zero count
                if (nums[j] <= 0 && current != 0) {
                    nonZeroCount--;
                    nums[j] = 0;
                }
            }

            // If all elements are zero, return step count
            if (nonZeroCount == 0) return i + 1;
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(minZeroArray(new int[]{4, 3, 2, 1}, new int[][]{{1, 3, 2}, {0, 2, 1}}));
    }
}
