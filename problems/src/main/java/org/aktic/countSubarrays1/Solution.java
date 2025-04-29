package org.aktic.countSubarrays1;

public class Solution {
    public static long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int left = 0;
        int right = 0;

        long count = 0;
        long res = 0;

        while (right < nums.length) {
            if (nums[right] == max) count++;

            while (count >= k) {
                res += nums.length - right;

                if (nums[left] == max) count--;
                left++;
            }

            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 3, 2, 3, 3}, 2));
    }
}
