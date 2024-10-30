package org.aktic.rotate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
//    public static int[] rotate(int[] nums, int k) {
//        int prev = 0;
//
//        if(nums.length == 2) k++;
//
//        for (int i = 0; i < k; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if(j == 0) {
//                    prev = nums[j];
//                    nums[j] = nums[nums.length - 1];
//                }else {
//                    int temp = nums[j];
//                    nums[j] = prev;
//                    prev = temp;
//                }
//            }
//        }
//
//        return nums;
//    }

    public static void rotate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int pos = (i + k) % nums.length;
            if (map.containsKey(pos)) {
                map.put(pos, map.get(pos));
                nums[pos] = nums[i];
            } else {
                map.put(pos, nums[pos]);
                nums[pos] = nums[i];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotate(new int[]{1,2,3,4,5,6,7}, 2)));
    }
}
