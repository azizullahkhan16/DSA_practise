package org.aktic.dojo;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int maxFreq(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int maxFreq = Integer.MIN_VALUE;
        int res = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                res = entry.getKey();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxFreq(new int[]{1, 2, 2, 3, 3, 3, 4}));

    }
}
