package org.aktic.clearDigits;

import java.util.Stack;

public class Solution {
    public static String clearDigits(String s) {
        StringBuilder res = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                res.append(c);
            } else {
                res.deleteCharAt(res.length() - 1);
            }
        }

        return res.toString();

    }

    public static void main(String[] args) {
        System.out.println(clearDigits("abc"));
    }
}
