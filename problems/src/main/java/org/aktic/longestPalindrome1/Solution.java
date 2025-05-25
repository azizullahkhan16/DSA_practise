package org.aktic.longestPalindrome1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            char c0 = words[i].charAt(0);
            char c1 = words[i].charAt(1);

            String temp = c1 + "" + c0;
            if (map.containsKey(temp)) {
                int num = map.get(temp);
                if (num > 1) {
                    map.put(temp, num - 1);
                } else {
                    map.remove(temp);
                }

                count += 4;
            } else {
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();

            if (key.charAt(0) == key.charAt(1)) {
                count += 2;
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome(new String[]{"qo", "fo", "fq", "qf", "fo", "ff", "qq", "qf", "of", "of", "oo", "of", "of", "qf", "qf", "of"}));
    }
}
