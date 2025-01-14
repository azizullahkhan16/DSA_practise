package org.aktic.maxNumberOfBalloons;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('b', 0);
        map.put('a', 0);
        map.put('l', 0);
        map.put('o', 0);
        map.put('n', 0);

        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == 'b' || text.charAt(i) == 'a' || text.charAt(i) == 'l' || text.charAt(i) == 'o' || text.charAt(i) == 'n') {
                map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0)+1);
            }
        }

        map.put('l', map.getOrDefault('l', 0)/2);
        map.put('o', map.getOrDefault('o', 0)/2);

        int min = Integer.MAX_VALUE;
        for(Integer count: map.values()) {
            min = Math.min(min, count);
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("leetcode"));
    }
}
