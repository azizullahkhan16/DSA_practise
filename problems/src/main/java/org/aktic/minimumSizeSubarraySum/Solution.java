package org.aktic.minimumSizeSubarraySum;

public class Solution {
//    public static int minSubArrayLen(int target, int[] nums) {
//        int minLength = 0;
//        int sum = 0;
//
//        for (int i = 1; i < nums.length+1; i++) {
//            for (int j = 0; j <= nums.length-i; j += 1) {
//                sum = 0;
//                for (int k = j; k < j+i; k++) {
//                    sum += nums[k];
//                }
//
//                if(sum >= target) minLength = i;
//            }
//
//            if(minLength > 0) break;
//
//        }
//
//        return minLength;
//    }

//    public static int minSubArrayLen(int target, int[] nums) {
//        int minLength = 0;
//        int sum = 0;
//
//        for (int i = 1; i < nums.length+1; i++) {
//            if(findMaxSum(nums, i, target)) return i;
//        }
//
//        return minLength;
//    }
//
//    public static boolean findMaxSum(int[] nums, int k, int target) {
//
//        double sum = 0;
//        double temp = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if(i < k-1) {
//                sum += nums[i];
//                continue;
//            } else if(i < k) {
//                sum += nums[i];
//                if(sum >= target) return true;
//                continue;
//            }
//            sum -= nums[i - k];
//            sum += nums[i];
//            if(sum >= target) return true;
//        }
//
//        return false;
//
//    }

    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                minLength = Math.min(minLength, i-left+1);
                sum -= nums[left];
                left++;
            }

        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }





}
