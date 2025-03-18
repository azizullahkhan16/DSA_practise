package org.aktic.longestNiceSubarray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int longestNiceSubarray(int[] nums) {
        int left = 0;
        int right = 1;
        int max = 1;

        while (right < nums.length) {
            int temp = right - 1;

            while (temp >= left) {
                int bitwise = nums[temp] & nums[right];
                if (bitwise != 0) {
                    left = temp + 1;
                }
                temp--;
            }

            max = Math.max(max, right - left + 1);

            right++;
        }

        return max;


    }

    public static void main(String[] args) {
        System.out.println(longestNiceSubarray(new int[]{1, 3, 8, 48, 10}));
    }
}
