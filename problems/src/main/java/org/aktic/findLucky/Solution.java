package org.aktic.findLucky;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == entry.getValue()) max = Math.max(max, entry.getKey());
        }

        return max == Integer.MIN_VALUE ? -1 : max;
    }

    public static void main(String[] args) {
        System.out.println(findLucky(new int[]{2, 2, 3, 4}));
    }
}
