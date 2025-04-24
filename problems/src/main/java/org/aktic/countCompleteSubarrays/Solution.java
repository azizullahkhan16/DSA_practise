package org.aktic.countCompleteSubarrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static int countCompleteSubarrays(int[] nums) {
        Set<Integer> fullDistinct = new HashSet<>();
        int res = 0;

        for (int num : nums) {
            fullDistinct.add(num);
        }

        int left = 0;
        int right = 0;
        Map<Integer, Integer> subDistinct = new HashMap<>();

        while (right < nums.length) {
            subDistinct.put(nums[right], subDistinct.getOrDefault(nums[right], 0) + 1);

            while (subDistinct.size() == fullDistinct.size()) {
                res += nums.length - right;
                subDistinct.put(nums[left], subDistinct.get(nums[left]) - 1);
                if (subDistinct.get(nums[left]) == 0) subDistinct.remove(nums[left]);
                left++;
            }

            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(countCompleteSubarrays(new int[]{5, 5, 5, 5}));
    }
}
