package org.aktic.sortedSquares;

import java.util.Arrays;

public class Solution {
    public static int[] sortedSquares(int[] nums) {
        int right = 0;
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) right++;
            else break;
        }
        int left = right - 1;
        int index = 0;
        while (index < nums.length) {
            if (right >= nums.length) {
                res[index++] = (int) Math.pow(nums[left--], 2);
            } else if (left < 0) {
                res[index++] = (int) Math.pow(nums[right++], 2);
            } else {
                if (Math.abs(nums[left]) < nums[right]) {
                    res[index++] = (int) Math.pow(nums[left--], 2);
                } else if (Math.abs(nums[left]) > nums[right]) {
                    res[index++] = (int) Math.pow(nums[right++], 2);
                } else {
                    res[index++] = (int) Math.pow(nums[left--], 2);
                    res[index++] = (int) Math.pow(nums[right++], 2);
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}
