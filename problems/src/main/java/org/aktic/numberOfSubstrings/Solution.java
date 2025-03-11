package org.aktic.numberOfSubstrings;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int numberOfSubstrings(String s) {
        int left = 0;
        int right = 0;
        int count = 0;

        Map<Character, Integer> map = new HashMap<>();


        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() == 3) {
                count += s.length() - right;
                char temp = s.charAt(left);
                map.put(temp, map.get(temp) - 1);
                if (map.get(temp) == 0) map.remove(temp);
                left++;
            }

            right++;
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("aaacb"));
    }
}
