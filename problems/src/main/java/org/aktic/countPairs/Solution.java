package org.aktic.countPairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
//    public static int countPairs(int[] nums, int k) {
//        int count = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] == nums[j] && (i * j) % k == 0) {
//                    count++;
//                }
//            }
//        }
//
//        return count;
//
//    }

    public static int countPairs(int[] nums, int k) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                ArrayList<Integer> temp = map.get(nums[i]);
                for (int index : temp) {
                    if (index * i % k == 0) {
                        count++;
                    }
                }
                map.get(nums[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{3, 1, 2, 2, 2, 1, 3}, 2));
    }
}
