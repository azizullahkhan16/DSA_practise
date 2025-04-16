package org.aktic.countGood;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static long countGood(int[] nums, int k) {
        long pairs = 0; // Current number of pairs in the window
        long count = 0; // Total number of good subarrays
        Map<Integer, Integer> freq = new HashMap<>(); // Frequency map for elements

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // Add nums[right] to the window
            int num = nums[right];
            // Update pairs: subtract old pairs, add new pairs
            int currFreq = freq.getOrDefault(num, 0);
            pairs -= (long) currFreq * (currFreq - 1) / 2; // Remove old pairs
            currFreq++;
            freq.put(num, currFreq);
            pairs += (long) currFreq * (currFreq - 1) / 2; // Add new pairs

            // Shrink window while pairs >= k
            while (left <= right && pairs >= k) {
                // All subarrays from left to right are good
                count += nums.length - right; // Count subarrays ending at right or beyond

                // Remove nums[left] from the window
                int leftNum = nums[left];
                int leftFreq = freq.get(leftNum);
                pairs -= (long) leftFreq * (leftFreq - 1) / 2; // Remove old pairs
                leftFreq--;
                if (leftFreq == 0) {
                    freq.remove(leftNum);
                } else {
                    freq.put(leftNum, leftFreq);
                }
                pairs += (long) leftFreq * (leftFreq - 1) / 2; // Add new pairs

                left++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countGood(new int[]{3, 1, 4, 3, 2, 2, 4}, 2));
    }
}
