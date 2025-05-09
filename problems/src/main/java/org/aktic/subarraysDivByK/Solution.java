package org.aktic.subarraysDivByK;

import java.util.HashMap;
import java.util.Map;

public class Solution {
//    public static int subarraysDivByK(int[] nums, int k) {
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int left = 0;
//            int right = i;
//            while (right < nums.length) {
//                if (check(nums, k, left, right)) {
//                    count++;
//                }
//                left++;
//                right++;
//            }
//        }
//
//        return count;
//    }


    //    public static boolean check(int[] nums, int k, int left, int right) {
//        int sum = 0;
//
//        for (int i = left; i <= right; i++) {
//            sum += nums[i];
//        }
//
//        return sum % k == 0;
//    }
    public static int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;

            if (remainder < 0) remainder += k;
            if (map.containsKey(remainder)) count += map.get(remainder);
            map.put(remainder, map.getOrDefault(sum % k, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{-1, 2, 9}, 2));
    }
}
