package org.aktic.maxNumberofKSumPairs;

import java.util.Arrays;

public class Solution {
    public static int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);

        int left = 0, right = nums.length - 1, operations = 0;

        while (left < right) {
            if(nums[left] + nums[right] == k) {
                operations++;
                right--;
                left++;
            }else if(nums[left] + nums[right] < k) {
                left++;
            }else {
                right--;
            }
        }

        return operations;

    }

    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{3,1,3,4,3}, 6));
    }
}
