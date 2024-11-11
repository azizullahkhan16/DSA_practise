package org.aktic.longestConsecutive;

import java.util.*;

public class Solution {
//    public static int longestConsecutive(int[] nums) {
//        Set<Integer> set = new TreeSet<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            set.add(nums[i]);
//        }
//
//        int temp = 0;
//        int max = 0;
//        int prev = Integer.MIN_VALUE;
//
//        for(Integer num : set) {
//            if(prev == Integer.MIN_VALUE) {
//                temp += 1;
//            } else {
//                if(num-1 == prev) {
//                    temp += 1;
//                } else {
//                    temp = 1;
//                }
//            }
//            prev = num;
//            max = Math.max(max, temp);
//        }
//
//
//        return max;
//    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{-8,-4,9,9,4,6,1,-4,-1,6,8}));
    }
}
