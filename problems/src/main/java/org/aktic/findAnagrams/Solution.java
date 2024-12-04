package org.aktic.findAnagrams;

import java.util.*;

public class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        List<Integer> result = new ArrayList<>();
        if(s.length() < k) return result;

        int[] countP = new int[26];
        int[] countS = new int[26];

        for (int i = 0; i < k; i++) {
            countP[p.charAt(i) - 'a']++;
            countS[s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(countP, countS)) result.add(0);

        for (int i = k; i < s.length(); i++) {
            countS[s.charAt(i) - 'a']++;
            countS[s.charAt(i-k) - 'a']--;
            if(Arrays.equals(countP, countS)) result.add(i-k+1);
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "cba"));
    }
}
