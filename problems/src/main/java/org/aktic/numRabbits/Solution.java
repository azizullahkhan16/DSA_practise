package org.aktic.numRabbits;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
//    public static int numRabbits(int[] answers) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int answer : answers) {
//            map.put(answer, map.getOrDefault(answer, 0) + 1);
//        }
//        int sum = 0;
//        for(Integer key : map.keySet()) {
//            if(key == 0) {
//                sum += map.get(key);
//            }else if(map.get(key) == key+1) {
//                sum += map.get(key);
//            }else if(map.get(key) < key+1) {
//                sum += key+1;
//            }else if(map.get(key) > key+1) {
//                sum += (map.get(key)/(key+1))*(key+1);
//                if (map.get(key)%(key+1) > 0) sum += (key+1);
//            }
//        }
//
//        return sum;
//    }

    public static int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int ans : answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }

        int rabbits = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey();
            int count = entry.getValue();

            int groupSize = x + 1;
            int groups = (count + groupSize - 1) / groupSize;
            rabbits += groups * groupSize;
        }

        return rabbits;
    }

    public static void main(String[] args) {
        System.out.println(numRabbits(new int[]{0, 1, 0, 2, 0, 1, 0, 2, 1, 1}));
    }
}
