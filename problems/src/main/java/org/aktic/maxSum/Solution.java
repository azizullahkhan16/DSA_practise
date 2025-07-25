package org.aktic.maxSum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);

        if (nums[nums.length - 1] <= 0) return nums[nums.length - 1];

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > 0) set.add(nums[i]);
            else break;
        }

        int res = 0;
        for (Integer num : set) {
            res += num;
        }

        return res;
    }

    public static void main(String[] args) {

    }
}

