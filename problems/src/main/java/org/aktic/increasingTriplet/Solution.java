package org.aktic.increasingTriplet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
//    public static boolean increasingTriplet(int[] nums) {
//        int max1 = nums[0], max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
//        for (int i = 1; i < nums.length; i++) {
//            if(nums[i] <= max1) {
//                max1 = nums[i];
//                continue;
//            }
//            max2 = nums[i];
//            for (int j = i+1; j < nums.length; j++) {
//                if(nums[j] > max2) {
//                    return true;
//                }
//            }
//
//        }
//
//        return false;
//    }

    public static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= a) {
                a = num;
            } else if (num <= b) {
                b = num;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{20,100,10,12,5,13}));
    }
}
