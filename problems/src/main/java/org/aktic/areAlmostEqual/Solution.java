package org.aktic.areAlmostEqual;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < count1.length; i++) {
            if (count1[i] != count2[i]) return false;
        }

        int diff = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) diff++;
            if (diff > 2) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(areAlmostEqual("defend", "attack"));
    }
}
