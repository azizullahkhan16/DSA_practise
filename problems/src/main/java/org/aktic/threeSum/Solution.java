package org.aktic.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();

        if (nums[left] > 0) return new ArrayList<>();

        while (left + 1 < right) {
            if (nums[left] + nums[left + 1] + nums[right] == 0) {
                res.add(Arrays.asList(nums[left], nums[left + 1], nums[right]));
            } else if (nums[left] + nums[right - 1] + nums[right] == 0) {
                res.add(Arrays.asList(nums[left], nums[right - 1], nums[right]));
            }

            if (nums[left] > 0) break;

            if (-nums[left] > nums[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
