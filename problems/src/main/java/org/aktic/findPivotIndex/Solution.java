package org.aktic.findPivotIndex;

class Solution {
    public static int pivotIndex(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];

        int sum = 0;
        for (int i = 0; i < leftSum.length; i++) {
            leftSum[i] = sum;
            sum += nums[i];
        }
        sum = 0;
        for (int i = rightSum.length-1; i >= 0; i--) {
            rightSum[i] = sum;
            sum += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if(leftSum[i] == rightSum[i]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,2,3}));
    }
}