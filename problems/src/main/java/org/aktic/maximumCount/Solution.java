package org.aktic.maximumCount;

public class Solution {
//    public static int maximumCount(int[] nums) {
//        int countNeg = 0;
//        int countPos = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] < 0) countNeg++;
//            else if (nums[i] > 0) countPos++;
//        }
//
//        return Math.max(countNeg, countPos);
//    }

    public static int maximumCount(int[] nums) {
        int n = nums.length;
        int firstNeg = -1, firstPos = -1;

        // Find the last index of a negative number (Binary Search)
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) {
                firstNeg = mid;  // Track the last negative number
                left = mid + 1;   // Search on the right side
            } else {
                right = mid - 1;  // Search on the left side
            }
        }

        // Find the first index of a positive number (Binary Search)
        left = 0;
        right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > 0) {
                firstPos = mid;  // Track the first positive number
                right = mid - 1; // Search on the left side
            } else {
                left = mid + 1;  // Search on the right side
            }
        }

        int negCount = (firstNeg == -1) ? 0 : firstNeg + 1;
        int posCount = (firstPos == -1) ? 0 : n - firstPos;

        return Math.max(negCount, posCount);
    }

    public static void main(String[] args) {
        System.out.println(maximumCount(new int[]{-2, -1, -1, 1, 2, 3}));
    }
}
