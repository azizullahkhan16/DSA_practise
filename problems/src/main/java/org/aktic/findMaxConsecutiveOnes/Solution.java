package org.aktic.findMaxConsecutiveOnes;

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                left = i;
                right = i + 1;
                while (right < nums.length && nums[right] == 1) {
                    right++;
                }

                res = Math.max(res, right - left);
                i = right - 1;
            }
        }

        return res;
    }
}
