package org.aktic.repeatedSubstringPattern;

public class Solution {
    public static boolean repeatedSubstringPattern(String s) {
        int count = s.length() / 2; // Start with half the string length
        int repeat = 2;

        while (count >= 1) {
            if (s.length() % count == 0) {
                String temp = s.substring(0, count);
                boolean isValid = true;

                for (int i = count; i < s.length(); i += count) {
                    if (!temp.equals(s.substring(i, i + count))) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) return true;
            }

            repeat++;
            count = s.length() / repeat;
        }

        return false;
    }



    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("ababab"));
    }
}
