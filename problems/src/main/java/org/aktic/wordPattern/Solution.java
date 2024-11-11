package org.aktic.wordPattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s+");
        if (pattern.length() != words.length) return false;

        Map<Character, String> map = new HashMap<>();
        Map<String, Character> s_map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(words[i])) return false;
            } else if(s_map.containsKey(words[i])){
                if (s_map.get(words[i]) != pattern.charAt(i)) return false;
            }else {
                map.put(pattern.charAt(i), words[i]);
                s_map.put(words[i], pattern.charAt(i));
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));

    }
}
