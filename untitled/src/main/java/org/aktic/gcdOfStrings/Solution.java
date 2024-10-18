package org.aktic.gcdOfStrings;

public class Solution {
    public static String gcdOfStrings(String str1, String str2) {
        if (str2.length() > str1.length()) return gcdOfStrings(str2, str1);
        for (int i = str2.length(); i > 0; i--) {
            if (str2.length() % i != 0) continue;
            String prefix = str2.substring(0, i);
            if (dividesString(str1, prefix) && dividesString(str2, prefix))
                return prefix;
        }

        return "";
    }

    private static boolean dividesString(String str, String prefix) {
        if (str.length() % prefix.length() != 0) return false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != prefix.charAt(i % prefix.length()))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
    }
}
