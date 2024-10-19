package org.aktic.validAnagram;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] S = s.toCharArray();
        char[] T = t.toCharArray();

        Arrays.sort(S);
        Arrays.sort(T);

        s = new String(S);
        t = new String(T);

        return s.equals(t);

    }

    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "car"));
    }
}
