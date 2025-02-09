package org.aktic.countBadPairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i] - i, map.getOrDefault(nums[i] - i, 0) + 1);
        }
        long totalPairs = ((long) nums.length * (nums.length - 1)) / 2;
        long goodPairs = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            goodPairs += ((long) entry.getValue() * (entry.getValue() - 1)) / 2;
        }

        return totalPairs - goodPairs;

    }

    public static void main(String[] args) {
        System.out.println(countBadPairs(new int[]{4, 1, 3, 3}));
    }
}
