package org.aktic.largestPerimeter;

import java.util.Arrays;

public class Solution {
    public static int largestPerimeter(int[] nums) {
        if(nums.length < 3) return 0;

        Arrays.sort(nums);

        for (int i = nums.length-1; i >= 2; i--) {
            if(nums[i] < nums[i-1] + nums[i-2])
                return nums[i]+nums[i-1]+nums[i-2];
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{3,9,2,5,2,19}));
    }
}
