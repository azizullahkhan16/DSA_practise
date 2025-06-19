package org.aktic.partitionArray;

import java.util.Arrays;

public class Solution {
    public static int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

        int count = 1;
        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - start > k) {
                start = nums[i];
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(partitionArray(new int[]{1, 2, 3}, 1));
    }
}
