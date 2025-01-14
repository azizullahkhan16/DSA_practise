package org.aktic.numIdenticalPairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int count = 0;
        for(Integer num: map.values()) {
            if(num > 1) {
                count += num * (num-1)/2;
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
