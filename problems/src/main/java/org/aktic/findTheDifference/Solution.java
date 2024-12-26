package org.aktic.findTheDifference;

public class Solution {
    public static char findTheDifference(String s, String t) {
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            charCount[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < charCount.length; i++) {
            if(charCount[i] == -1) return (char) ('a' + i);
        }

        return (char) 0;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
    }
}
