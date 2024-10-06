package org.aktic.missingNumber;

public class Solution {
    public static int missingNumber(int[] nums) {
        int[] result = new int[nums.length + 1];

        int numZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) numZeros++;
            result[nums[i]] = nums[i];
        }
        if(numZeros == 0) return 0;

        for (int i = 1; i < result.length; i++) {
            if(result[i] == 0) return i;
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{1, 2}));
    }
}
