package org.aktic.singleNumber;

import java.util.HashMap;
import java.util.Map;

public class Solution {
//    public static int singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        for(int key : map.keySet()) {
//            if(map.get(key) == 1) return key;
//        }
//
//        return -1;
//    }

    public static int singleNumber(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i++){
            xor = xor ^ nums[i];
        }

        return xor;
    }


    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
