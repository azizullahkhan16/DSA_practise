package org.aktic.divideArray;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static boolean divideArray(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }

        return set.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(divideArray(new int[]{1, 2, 3, 4}));
    }
}
