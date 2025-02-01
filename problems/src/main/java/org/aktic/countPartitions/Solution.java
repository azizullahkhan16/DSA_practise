package org.aktic.countPartitions;

public class Solution {
    public static int countPartitions(int[] nums) {
        int[] sums = new int[nums.length];
        sums[sums.length-1] = nums[nums.length-1];

        for (int i = nums.length-2; i >= 0; i--) {
            sums[i] = nums[i] + sums[i+1];
        }

        int sum = nums[0];
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if((sums[i] - sum) % 2 == 0) count++;
            sum += nums[i];
        }

        return count;

    }

    public static void main(String[] args) {
        System.out.println(countPartitions(new int[] {10,10,3,7,6}));
    }
}
