package org.aktic.longestUniqueSubstr;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int longestUniqueSubstr(String s) {
        // code here
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int max = set.size();

        int left = 0;
        int right = 1;

        while (right < s.length()) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            max = Math.max(max, set.size());
            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestUniqueSubstr("geeksforgeeks"));
    }
}
