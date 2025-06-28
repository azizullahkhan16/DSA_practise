package org.aktic.maxSubsequence1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static int[] maxSubsequence(int[] nums, int k) {
        Arrays.sort(nums);
        int[] res = new int[k];
        int index = nums.length - k;

        for (int i = 0; i < res.length; i++) {
            res[i] = nums[index++];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSubsequence(new int[]{50, -75}, 2)));
    }
}
