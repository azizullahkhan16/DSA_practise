package org.aktic.countSubarrays;

public class Solution {
    public static int countSubarrays(int[] nums) {
        if (nums.length < 3) return 0;
        int count = 0;
        int left = 0;
        int right = left + 2;

        while (right < nums.length) {
            int half = nums[left] + nums[right];
            double mid = nums[left + 1];


            if (half == mid / 2) count++;
            left++;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 2, 1, 4, 1}));
    }
}
