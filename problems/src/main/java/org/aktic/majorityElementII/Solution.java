package org.aktic.majorityElementII;

import java.util.*;

public class Solution {
//    public static List<Integer> majorityElement(int[] nums) {
//        if(nums.length == 1) return new ArrayList<>(List.of(nums[0]));
//        Arrays.sort(nums);
//
//        List<Integer> majority = new ArrayList<>();
//        int req = nums.length/3;
//        int count = 1;
//        int curr = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            if(nums[i] != curr) {
//                if(count > req) majority.add(curr);
//                count = 1;
//                curr = nums[i];
//            }else {
//                count++;
//            }
//        }
//
//        if(majority.isEmpty()) {
//            if(count > req) majority.add(curr);
//        }else {
//            if(majority.getLast() != curr && count > req) majority.add(curr);
//        }
//
//        return majority;
//    }

    public static List<Integer> majorityElement(int[] nums) {
        if(nums.length == 1) return new ArrayList<>(List.of(nums[0]));
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer> majority = new ArrayList<>();
        int req = nums.length/3;

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() > req) majority.add(entry.getKey());
        }

        return majority;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {3, 2, 3}));
    }
}
