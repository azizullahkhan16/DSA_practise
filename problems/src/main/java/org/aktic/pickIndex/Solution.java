package org.aktic.pickIndex;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    private double[] cumulativeWeights;
    private Random rand;

    public Solution(int[] w) {
        // Create a cumulative weights array
        cumulativeWeights = new double[w.length];
        cumulativeWeights[0] = w[0]; // Initialize first cumulative weight
        for (int i = 1; i < w.length; i++) {
            cumulativeWeights[i] = cumulativeWeights[i - 1] + w[i];
        }
        rand = new Random();
    }

    public int pickIndex() {
        // Generate a random number in the range [0, total sum)
        double target = rand.nextDouble() * cumulativeWeights[cumulativeWeights.length - 1];

        // Perform binary search to find the corresponding index
        int left = 0, right = cumulativeWeights.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > cumulativeWeights[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // Index corresponding to the target
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 7, 14};
        Solution solution = new Solution(nums);
        System.out.println(solution.pickIndex());
    }
}

