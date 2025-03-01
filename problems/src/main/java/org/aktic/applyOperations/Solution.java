package org.aktic.applyOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int[] applyOperations(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums;

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                res[index] = nums[i];
                index++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(applyOperations(new int[]{1, 2, 2, 1, 1, 0})));
    }
}
