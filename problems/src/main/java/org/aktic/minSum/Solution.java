package org.aktic.minSum;

public class Solution {
    public static long minSum(int[] nums1, int[] nums2) {
        long num1Sum = 0;
        long num2Sum = 0;
        int num1Zeros = 0;
        int num2Zeros = 0;

        for (int num : nums1) {
            num1Sum += num;
            if (num == 0) {
                num1Sum++;
                num1Zeros++;
            }
        }

        for (int num : nums2) {
            num2Sum += num;
            if (num == 0) {
                num2Sum++;
                num2Zeros++;
            }
        }

        if ((num1Zeros == 0 && num2Sum > num1Sum) || (num2Zeros == 0 && num1Sum > num2Sum)) return -1;

        return Math.max(num1Sum, num2Sum);
    }


}
