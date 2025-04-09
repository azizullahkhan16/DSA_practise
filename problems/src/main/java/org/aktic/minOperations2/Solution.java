package org.aktic.minOperations2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int minOperations(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            min = Math.min(min, num);
            set.add(num);
        }

        if (min > k) return set.size();
        else if (min < k) return -1;
        else return set.size() - 1;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{9, 7, 5, 3}, 1)); // Output: 2
    }
}
