package org.aktic.minCapability;

public class Solution {
    public static int minCapability(int[] nums, int k) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            left = Math.min(left, nums[i]);
            right = Math.max(right, nums[i]);
        }

        int res = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isValid(mid, nums, k)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    public static boolean isValid(int capability, int[] nums, int k) {
        int i = 0;
        int count = 0;

        while (i < nums.length) {
            if (nums[i] <= capability) {
                i += 2;
                count++;
            } else i++;

            if (count == k) break;
        }

        return count == k;
    }


    public static void main(String[] args) {
        System.out.println(minCapability(new int[]{2, 7, 9, 3, 1}, 2));
    }
}
