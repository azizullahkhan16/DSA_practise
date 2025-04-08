package org.aktic.minimumOperations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static int minimumOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, -1) + 1);
        }

        Set<Integer> set = new HashSet<>();

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() < 2) set.add(e.getKey());
        }

        for (Integer num : set) {
            map.remove(num);
        }

        if (map.isEmpty()) return 0;

        int min = 0;
        int left = 0;
        while (true) {
            min++;
            int count = 0;

            while (count < 3 && left < nums.length && !map.isEmpty()) {
                if (map.containsKey(nums[left])) {
                    map.put(nums[left], map.get(nums[left]) - 1);
                    if (map.get(nums[left]) == 0) {
                        map.remove(nums[left]);
                    }
                }
                count++;
                left++;
            }

            if (left >= nums.length || map.isEmpty()) {
                break;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1, 2, 3, 4, 2, 3, 3, 5, 7}));
    }
}
