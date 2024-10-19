package org.aktic.isSubsequence;

public class Solution {
    public static boolean isSubsequence(String s, String t) {
        int left = 0, right = 0;

        while (left < s.length() && right < t.length()) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
                right++;
            }else {
                right++;
            }
        }

        return left >= s.length() ;
    }


    public static void main(String[] args) {
        System.out.println(isSubsequence("abct", "ahbgdc"));
    }
}
