package org.aktic.isIsomorphic;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> s_map = new HashMap<>();
        Map<Character, Character> t_map = new HashMap<>();

        int left = 0;
        int right = 0;

        while(left < s.length() && right < t.length()) {
            if(!s_map.containsKey(s.charAt(left)) && !t_map.containsKey(t.charAt(right))) {
                s_map.put(s.charAt(left), t.charAt(right));
                t_map.put(t.charAt(right), s.charAt(left));
            }
            left++;
            right++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s_map.get(s.charAt(i)));
        }

        return sb.toString().equals(t);
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba"));
    }
}
