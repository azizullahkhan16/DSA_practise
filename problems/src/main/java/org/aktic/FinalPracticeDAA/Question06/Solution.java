package org.aktic.FinalPracticeDAA.Question06;

public class Solution {
    private static int countInversion(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] > nums[j] && i < j) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countInversion(new int[] {3, 2, 1, 4}));
    }
}
