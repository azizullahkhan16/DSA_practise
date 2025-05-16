package org.aktic.getWordsInLongestSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        if (words.length == 1) return List.of(words[0]);
        int[] dp = new int[words.length];
        int[] prev = new int[words.length];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int max = 1;
        int maxEnd = -1;

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && words[i].length() == words[j].length()) {
                    if (isHamming(words[i], words[j])) {
                        if (dp[j] + 1 > dp[i]) {
                            dp[i] = dp[j] + 1;
                            prev[i] = j;
                        }
                    }
                }
            }

            if (dp[i] > max) {
                max = dp[i];
                maxEnd = i;
            }
        }

        List<String> res = new ArrayList<>();

        while (maxEnd != -1) {
            res.addFirst(words[maxEnd]);
            maxEnd = prev[maxEnd];
        }

        return res;
    }

    private static boolean isHamming(String w1, String w2) {
        boolean isHamming = false;

        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                if (isHamming) return false;
                else isHamming = true;
            }
        }

        return isHamming;
    }

    public static void main(String[] args) {
        System.out.println(getWordsInLongestSubsequence(new String[]{"bab", "dab", "cab"}, new int[]{1, 2, 2}));
    }
}
