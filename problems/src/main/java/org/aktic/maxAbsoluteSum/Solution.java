package org.aktic.maxAbsoluteSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int maxAbsoluteSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int currSum = 0;
        int currMinSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            currMinSum += nums[i];

            if (currSum < nums[i]) {
                currSum = nums[i];
            }

            if (currMinSum > nums[i]) {
                currMinSum = nums[i];
            }

            maxSum = Math.max(maxSum, currSum);
            minSum = Math.min(minSum, currMinSum);
        }

        return Math.max(maxSum, Math.abs(minSum));
    }

    public static void main(String[] args) {
        System.out.println(maxAbsoluteSum(new int[]{-7, -1, 0, -2, 1, 3, 8, -2, -6, -1, -10, -6, -6, 8, -4, -9, -4, 1, 4, -9}));
    }
}
