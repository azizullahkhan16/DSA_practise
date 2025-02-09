package org.aktic.countNicePairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public static int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int goodPairs = 0;

        for (int num : nums) {
            int temp = rev(num);
            int diff = num - temp;
            int count = map.getOrDefault(diff, 0);

            // Add count to goodPairs before updating the map (to avoid double counting)
            goodPairs = (goodPairs + count) % MOD;

            // Update the map with the new frequency
            map.put(diff, (count + 1) % MOD);
        }

        return goodPairs;
    }

    public static int rev(int num) {
        int revNum = 0;
        while (num > 0) {
            revNum = revNum * 10 + num % 10;
            num /= 10;
        }
        return revNum;
    }

    public static void main(String[] args) {
        System.out.println(countNicePairs(new int[]{42, 11, 1, 97, 111}));
    }
}
