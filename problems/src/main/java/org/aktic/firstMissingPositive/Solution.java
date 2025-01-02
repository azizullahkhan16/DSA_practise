package org.aktic.firstMissingPositive;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static int firstMissingPositive(int[] nums) {
        boolean hasOne = false;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) hasOne = true;
            else {
                if(nums[i] <= 0 || nums[i] > nums.length) nums[i] = 1;
            }
        }

        if(!hasOne) return 1;

        for (int i = 0; i < nums.length; i++) {
            int value = Math.abs(nums[i]);
            if (value == nums.length) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[value] = -Math.abs(nums[value]);
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > 0) return i;
        }

        if (nums[0] > 0) {
            return nums.length;
        }

        return nums.length+1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }
}
