package org.aktic.firstOccurrence;

public class Solution {
    public static int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            String temp = haystack.substring(i, i + needle.length());
            if (temp.equals(needle)) return i;
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(strStr("butsad", "sad"));
    }
}
