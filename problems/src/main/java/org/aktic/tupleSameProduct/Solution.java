package org.aktic.tupleSameProduct;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }

        int tuples = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                tuples += (entry.getValue() * 2) * ((entry.getValue() * 2) - 2);
            }
        }

        return tuples;
    }

    public static void main(String[] args) {
        System.out.println(tupleSameProduct(new int[]{2, 3, 4, 6, 8, 12}));
    }
}
