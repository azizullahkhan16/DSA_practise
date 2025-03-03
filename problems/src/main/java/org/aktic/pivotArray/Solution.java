package org.aktic.pivotArray;

import java.util.Arrays;

public class Solution {
    public static int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                res[index++] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pivot) {
                res[index++] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pivot) {
                res[index++] = nums[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10)));
    }
}
