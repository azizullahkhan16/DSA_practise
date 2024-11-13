package org.aktic.lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;

        int left = 0;
        int right = 0;

        for (; right < s.length(); right++) {
            if(map.containsKey(s.charAt(right))) {
                for (; left < map.get(s.charAt(right)); left++) {
                    map.remove(s.charAt(left));
                }
                left = map.get(s.charAt(right)) + 1;
                map.put(s.charAt(right), right);
            }else {
                map.put(s.charAt(right), right);
                max = Math.max(max, right-left+1);
            }
        }

        return max;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
