package org.aktic.majorityElement;

import java.util.HashMap;
import java.util.Map;

public class Solution {
//    public static int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//
//        int max = 0;
//
//        for(int num : nums) {
//            int count = map.getOrDefault(num, 0) + 1;
//            map.put(num, count);
//
//            if(count > nums.length/2) max = num;
//        }
//
//        return max;
//    }

    public static int majorityElement(int[] nums) {
        int majority = 0;
        int count = 0;


        for (int i = 0; i < nums.length; i++) {
            if(count == 0) majority = nums[i];

            if(nums[i] == majority) count++;
            else count--;
        }

        return majority;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
