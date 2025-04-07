package org.aktic.canPartition;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static boolean canPartition(int[] nums) {
        if (nums.length == 1) return false;
        if (nums.length == 2 && nums[0] != nums[1]) return false;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) return false;

        int half = sum / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> temp = new HashSet<>();
            for (Integer num : dp) {
                if (num + nums[i] == half) return true;
                temp.add(num + nums[i]);
            }

            dp.addAll(temp);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
    }
}
