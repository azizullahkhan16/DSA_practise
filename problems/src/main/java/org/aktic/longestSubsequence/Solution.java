package org.aktic.longestSubsequence;

public class Solution {
    public static int longestSubsequence(String s, int k) {
        double[] nums = new double[s.length()];
        int index = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                nums[i] = Math.pow(2, index);
            } else {
                nums[i] = 0;
            }

            index++;
        }

        int max = 0;
        int sum = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum <= k || nums[i] == 0) {
                max++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubsequence("00101001", 1));
    }
}
