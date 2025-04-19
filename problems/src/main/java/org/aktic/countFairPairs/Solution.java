package org.aktic.countFairPairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
//    public static long countFairPairs(int[] nums, int lower, int upper) {
//        long count = 0;
//
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                int sum = nums[i] + nums[j];
//                if (sum >= lower && sum <= upper) count++;
//            }
//        }
//
//        return count;
//    }

    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            int low = binarySearch(nums, i + 1, nums.length - 1, lower - nums[i]);
            int high = binarySearch(nums, i + 1, nums.length - 1, upper - nums[i] + 1);

            count += (high - low);
        }

        return count;
    }

    public static int binarySearch(int[] nums, int low, int high, int element) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= element) {
                high = mid - 1;
            } else low = mid + 1;
        }

        return low;
    }

    public static void main(String[] args) {
        System.out.println(countFairPairs(new int[]{0, 0, 0, 0, 0, 0}, 0, 0));
    }
}
