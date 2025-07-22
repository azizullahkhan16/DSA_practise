package org.aktic.maximumUniqueSubarray;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        int sum = 0;

        int left = 0;
        int right = 0;

        while (right < nums.length) {

            while (!set.isEmpty() && set.contains(nums[right])) {
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }

            sum += nums[right];
            set.add(nums[right]);
            res = Math.max(res, sum);

            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
    }
}
