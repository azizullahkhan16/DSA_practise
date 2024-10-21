package org.aktic.maxVowels;

import java.util.Map;

class Solution {
    public static int maxVowels(String s, int k) {
        int left = 0, right = 0;
        int max = Integer.MIN_VALUE, count = 0;

        for (int i = 0; i < s.length(); i++) {
            if(i < k) {
                if(isVowel(s.charAt(i))) count++;
                max = Math.max(max, count);
                right++;
                continue;
            }

            if(isVowel(s.charAt(i))) count++;
            if(isVowel(s.charAt(left))) count--;
            max = Math.max(max, count);
            left++;
        }

        return max;


    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiide", 3));
    }
}