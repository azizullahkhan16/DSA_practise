package org.aktic.minOperations1;

public class Solution {
    public static int minOperations(int[] nums) {
        int min = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                if (i + 2 < nums.length) {
                    nums[i] = nums[i] == 0 ? 1 : 0;
                    nums[i + 1] = nums[i + 1] == 0 ? 1 : 0;
                    nums[i + 2] = nums[i + 2] == 0 ? 1 : 0;

                    min++;
                } else return -1;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{0, 1, 1, 1, 0, 0}));
    }
}
