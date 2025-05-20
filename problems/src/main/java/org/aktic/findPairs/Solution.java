package org.aktic.findPairs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static int findPairs(int[] nums, int k) {
        if (k < 0) return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        for (int num : freq.keySet()) {
            if (k == 0) {
                if (freq.get(num) > 1) count++;
            } else {
                if (freq.containsKey(num + k)) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, 3));
    }
}
