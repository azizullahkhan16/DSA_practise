package org.aktic.FinalPracticeDAA.Question04;

public class Solution {

    private static int missingNumber(int[] nums) {
        int[] memo = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            memo[nums[i]-1] = 1;
        }

        for (int i = 0; i < memo.length; i++) {
            if(memo[i] == 0) return i+1;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 2, 4, 6, 5, 7}));
    }
}
