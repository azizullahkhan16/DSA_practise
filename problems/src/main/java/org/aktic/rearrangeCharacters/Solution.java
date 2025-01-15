package org.aktic.rearrangeCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int rearrangeCharacters(String s, String target) {
        int[] targetCount = new int[26];
        for(char c : target.toCharArray()) {
            targetCount[c-'a']++;
        }

        int[] sCount = new int[26];
        for(char c: s.toCharArray()) {
            if(targetCount[c-'a'] > 0) {
                sCount[c-'a']++;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if(targetCount[i] == 0 && sCount[i] == 0) continue;
            min = Math.min(min, sCount[i]/targetCount[i]);
        }

        return min;

    }

    public static void main(String[] args) {
        System.out.println(rearrangeCharacters("ilovecodingonleetcode", "code"));
    }
}
