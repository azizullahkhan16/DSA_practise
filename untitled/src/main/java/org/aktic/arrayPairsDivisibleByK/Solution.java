package org.aktic.arrayPairsDivisibleByK;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public static boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            int rem = ((i % k) + k) % k;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }


        for (int i : arr) {
            int rem = ((i % k) + k) % k;

            if (rem == 0) {
                if (map.get(rem) % 2 == 1) return false;
            }
            else if (!Objects.equals(map.get(rem), map.get(k - rem))) return false;
        }
        return true;
    }

//    public static boolean canArrange(int[] arr, int k) {
//        boolean[] bools = new boolean[arr.length];
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length && !bools[i]; j++) {
//                if((arr[i] + arr[j]) % k == 0 && !bools[j]) {
//                    bools[i] = true;
//                    bools[j] = true;
//                    break;
//                }
//            }
//        }
//
//        for (int i = 0; i < bools.length; i++) {
//            if(!bools[i]) return false;
//        }
//
//        return true;
//    }


    public static void main(String[] args) {
        int[] nums = {3,8,17,2};
        System.out.println(canArrange(nums, 10));
    }
}
