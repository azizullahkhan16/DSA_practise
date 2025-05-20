package org.aktic.isZeroArray;

import java.util.Arrays;

public class Solution {
    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int[] diff = new int[nums.length + 1];

        for (int[] query : queries) {
            diff[query[0]]++;
            diff[query[1] + 1]--;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += diff[i];
            if (sum < nums[i]) return false;
        }

        return true;
    }

    public static void makeOne(int[] nums, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (nums[i] != 0) nums[i]--;
        }
    }

    public static void main(String[] args) {
        System.out.println(isZeroArray(new int[]{1, 6, 6, 7}, new int[][]{{1, 2},
                {2, 2},
                {3, 3},
                {2, 2},
                {1, 2},
                {3, 3},
                {3, 3},
                {0, 2},
                {0, 1},
                {0, 0},
                {0, 3},
                {1, 3}}));
    }
}
