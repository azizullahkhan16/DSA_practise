package org.aktic.smallestNumber;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String smallestNumber(String pattern) {
        String res = "";
        pattern = "I" + pattern;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'I' && pattern.charAt(i + 1) == 'D') {
                int temp = 1;
                int count = i + 2;
                while (count < pattern.length() && pattern.charAt(count) == 'D') {
                    temp++;
                    count++;
                }
                map.put(i, temp);
                i = count - 1;
            }
        }
        int count = 1;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'I') {
                res += count + map.getOrDefault(i, 0);
            } else {
                int temp = res.charAt(res.length() - 1) - '0';
                res += temp - 1;
            }
            count++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(smallestNumber("IIIDIDDD"));
    }
}
