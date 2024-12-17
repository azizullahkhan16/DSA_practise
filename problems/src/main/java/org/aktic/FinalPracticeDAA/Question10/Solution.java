package org.aktic.FinalPracticeDAA.Question10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static int[] findPair(int[] nums, int k) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]+k)) {
                return new int[]{map.get(nums[i]+k), i};
            }
            if (map.containsKey(nums[i]-k)) {
                return new int[]{map.get(nums[i]-k), i};
            }

            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPair(new int[]{1, 2, 3, -4, 5, 6, 7, 8, 9}, 3)));
    }
}
