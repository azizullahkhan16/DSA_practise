package org.aktic.containsNearbyDuplicate;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if(Math.abs(map.get(nums[i]) - i) <= k) return true;
                else map.put(nums[i], i);
            }else map.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[] {1,0,1,1}, 1));
    }
}
