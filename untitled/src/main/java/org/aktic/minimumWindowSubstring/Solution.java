package org.aktic.minimumWindowSubstring;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public boolean hasCharInT(char s, char[] T) {
        for (char c : T) {
            if (c == s) return true;
        }

        return false;
    }
    public String minWindow(String s, String t) {

        int max = 0;
        int left = 0;
        int right = 1;

        boolean isValid = false;

        char[] S = s.toCharArray();
        char[] T = t.toCharArray();

        Queue<Character> q = new LinkedList<Character>();


        int charLeft = T.length;

        ArrayList<Character> window = new ArrayList<>();

        for (int i = 0; i < S.length; i++) {
            window.add(S[left]);
            while (charLeft != 0) {
                if(hasCharInT(S[right], T)) charLeft--;
                right++;

            }
        }

        return s.substring(left, right+1);

    }
}
