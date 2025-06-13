package org.aktic.minimizeMax;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static int minimizeMax(int[] nums, int p) {
        if (p == 0) return 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = (left + right) / 2;
            if (canFormPairs(nums, mid, p)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canFormPairs(int[] nums, int maxDiff, int p) {
        int count = 0;
        int i = 1;

        while (i < nums.length) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                count++;
                i += 2;
            } else {
                i++;
            }

            if (count == p) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(minimizeMax(new int[]{10, 1, 2, 7, 1, 3}, 2));
    }
}
