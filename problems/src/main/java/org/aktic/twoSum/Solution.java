package org.aktic.twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();


        for (int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i+1};
            }else {
                map.put(numbers[i], i+1);
            }
        }

        return null;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
    }
}
