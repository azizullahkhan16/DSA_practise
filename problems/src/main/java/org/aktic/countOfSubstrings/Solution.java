package org.aktic.countOfSubstrings;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static long countOfSubstrings(String word, int k) {
        return checkSubstring(word, k) - checkSubstring(word, k + 1);
    }

    public static long checkSubstring(String word, int k) {
        long res = 0;
        int left = 0;
        int right = 0;

        Map<Character, Integer> map = new HashMap<>();
        int consonantCount = 0;

        while (right < word.length()) {
            char c = word.charAt(right);

            if (isVowel(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            } else {
                consonantCount++;
            }

            while (map.size() == 5 && consonantCount >= k) {
                res += word.length() - right;
                char temp = word.charAt(left);
                if (isVowel(temp)) {
                    map.put(temp, map.get(temp) - 1);
                    if (map.get(temp) == 0) map.remove(temp);
                } else {
                    consonantCount--;
                }

                left++;
            }

            right++;
        }

        return res;
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        System.out.println(countOfSubstrings("iqeaouqi", 2));
    }
}
