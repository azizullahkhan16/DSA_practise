package org.aktic.longestSubarray;

public class Solution1 {
    public static int longestSubarray(int[] nums) {
        int beforeZero = 0;
        int afterZero = 0;
        int max = 0;
        boolean hasFound = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (hasFound) afterZero++;
                else beforeZero++;
            } else if (nums[i] == 0 && !hasFound) {
                hasFound = true;
            } else if (i - 1 >= 0 && (nums[i - 1] == 0 && nums[i] == 0)) {
                beforeZero = 0;
                afterZero = 0;
            } else {
                beforeZero = afterZero;
                afterZero = 0;
            }

            if (!hasFound) max = Math.max(max, beforeZero - 1);
            else max = Math.max(max, beforeZero + afterZero);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1, 1, 1}));
    }
}
