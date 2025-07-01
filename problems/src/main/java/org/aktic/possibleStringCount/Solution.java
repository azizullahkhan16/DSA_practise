package org.aktic.possibleStringCount;

public class Solution {
    public static int possibleStringCount(String word) {
        int possible = 1;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                possible++;
            }
        }


        return possible;
    }

    public static void main(String[] args) {
        System.out.println(possibleStringCount("abbcccc"));
    }
}
