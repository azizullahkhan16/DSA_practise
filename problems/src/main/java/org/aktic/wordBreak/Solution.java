package org.aktic.wordBreak;

import java.util.*;

public class Solution {

    // Example dictionary using a set (you can replace dict function with this)
    private static Set<String> dictionary = new HashSet<>();

    // Helper function to determine if the string s can be segmented
    public static boolean wordBreak(String s, List<String> dict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;  // Base case: empty string is valid

        // Iterate over the string
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // Check if the substring from j to i is a valid word and dp[j] is true
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;  // No need to check further for this i
                }
            }
        }

        return dp[n];  // Return if the full string can be segmented
    }

    public static void main(String[] args) {
        // Example dictionary words
        dictionary.add("it");
        dictionary.add("was");
        dictionary.add("the");
        dictionary.add("best");
        dictionary.add("of");
        dictionary.add("times");

        String input = "itwasthebestoftimes";
        System.out.println("Can the string be segmented? " + wordBreak(input, new ArrayList<>()));  // Output: true
    }
}