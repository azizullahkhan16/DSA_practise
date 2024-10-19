package org.aktic.longestPalindrome;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
//    public static int longestPalindrome(String s) {
//        if(s.length() == 1) return 1;
//        int longest = 0;
//
//        char[] S = s.toCharArray();
//
//        Arrays.sort(S);
//
//        boolean isOdd = false;
//
//        for (int i = 1; i < S.length; i++) {
//            if(S[i-1] == S[i]) {
//                longest += 2;
//                i++;
//            } else if(!isOdd && S[i-1] != S[i]) {
//                isOdd = true;
//                longest++;
//            }
//        }
//
//        if(!isOdd && longest == S.length-1) longest++;
//
//        return longest;
//
//    }

    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int odd = 0;

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);


            if((map.get(c) % 2) == 1) odd++;
            else odd--;

        }

        if(odd > 0) return s.length() - odd + 1;
        else return s.length();
    }




    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
    }
}
