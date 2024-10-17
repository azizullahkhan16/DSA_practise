package org.aktic.mergeAlternately;

public class Solution {
    public static String mergeAlternately(String word1, String word2) {
        String result = "";

        int left = 0, right = 0;

        while(left < word1.length() && right < word2.length()) {
            result += String.valueOf(word1.charAt(left)) + word2.charAt(right);
            left++;
            right++;
        }

        if (left < word1.length()) {
            result += word1.substring(left);
        }

        if (right < word2.length()) {
            result += word2.substring(right);
        }



        return result;
    }


    public static void main(String[] args) {
        System.out.println(mergeAlternately("ab", "pqrs"));
    }
}