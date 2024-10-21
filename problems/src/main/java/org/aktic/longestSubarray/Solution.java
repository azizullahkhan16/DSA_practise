package org.aktic.longestSubarray;

public class Solution {
    public static int longestSubarray(int[] nums) {
        int left = 0, max = 0, zeroCount = 0, k = 1;

        for (int right = 0; right < nums.length; right++) {
            // If we encounter a 0, increment zeroCount
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If zeroCount exceeds k, move the left pointer to reduce zeros in the window
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++; // Shrink the window
            }

            // Update max with the current window size
            max = Math.max(max, right - left);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,1,1}));
    }
}
