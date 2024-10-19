package org.aktic.maximumAverageSubarray;

public class Solution {
//    public static double findMaxAverage(int[] nums, int k) {
//
//        double maxAverage = 0;
//        double sum = 0;
//
//        for (int i = 0; i < k; i++) {
//            sum += nums[i];
//        }
//
//        maxAverage = sum / k;
//
//        double temp = 0;
//
//        for (int i = 1; i < nums.length - k + 1; i++) {
//            sum -= nums[i - 1];
//            sum += nums[i+k-1];
//            temp = sum / k;
//            if(temp > maxAverage) maxAverage = temp;
//        }
//
//        return maxAverage;
//
//    }

    public static double findMaxAverage(int[] nums, int k) {

        double maxAverage = Double.NEGATIVE_INFINITY;
        double sum = 0;
        double temp = 0;

        for (int i = 0; i < nums.length; i++) {
            if(i < k-1) {
                sum += nums[i];
                continue;
            } else if(i < k) {
                sum += nums[i];
                maxAverage = sum / k;
                continue;
            }
            sum -= nums[i - k];
            sum += nums[i];
            temp = sum / k;
            if(temp > maxAverage) maxAverage = temp;
        }

        if(maxAverage == Double.NEGATIVE_INFINITY) {
            maxAverage = sum / k;
        }

        return maxAverage;

    }

    public static boolean findMaxSum(int[] nums, int k, int target) {

        double sum = 0;
        double temp = 0;

        for (int i = 0; i < nums.length; i++) {
            if(i < k-1) {
                sum += nums[i];
                continue;
            } else if(i < k) {
                sum += nums[i];
                continue;
            }
            sum -= nums[i - k];
            sum += nums[i];
            if(sum >= target) return true;
        }

        return false;

    }
}
