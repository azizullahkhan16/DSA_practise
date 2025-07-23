package org.aktic.maximumGain;

import java.util.Map;
import java.util.Stack;

public class Solution {
//    public static int maximumGain(String s, int x, int y) {
//        boolean hasChanged = false;
//        int res = 0;
//        String first = x >= y ? "ab" : "ba";
//        String second = first.equals("ab") ? "ba" : "ab";
//        char secondChar = first.equals("ab") ? 'b' : 'a';
//        StringBuilder original = new StringBuilder(s);
//
//        while (!hasChanged) {
//            hasChanged = true;
//
//            for (int i = 0; i < original.length() - 1; i++) {
//                if (original.substring(i, i + 2).equals(first)) {
//                    res += first.equals("ab") ? x : y;
//                    hasChanged = false;
//                    original.replace(i, i + 2, "");
//                    break;
//                }
//            }
//
//            if (hasChanged) {
//                for (int i = 0; i < original.length() - 1; i++) {
//                    if (original.substring(i, i + 2).equals(second)) {
//                        res += second.equals("ba") ? y : x;
//                        hasChanged = false;
//                        original.replace(i, i + 2, "");
//                        break;
//                    }
//
//                }
//            }
//        }
//
//        return res;
//    }

    public static int maximumGain(String s, int x, int y) {
        String first = x > y ? "ab" : "ba";
        String second = first.equals("ab") ? "ba" : "ab";

        // first pass
        String firstRes = passString(s, first);
        int firstPair = (s.length() - firstRes.length()) / 2;

        // second pass
        String secondPass = passString(firstRes, second);
        int secondPair = (firstRes.length() - secondPass.length()) / 2;

        return (firstPair * Math.max(x, y)) + (secondPair * Math.min(x, y));
    }

    private static String passString(String s, String targetChar) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }

            if (s.charAt(i) == targetChar.charAt(1) && stack.peek() == targetChar.charAt(0)) {
                stack.pop();
            } else stack.push(s.charAt(i));
        }

        StringBuilder resString = new StringBuilder();

        for (Character c : stack) {
            resString.append(c);
        }

        return resString.toString();
    }


    public static void main(String[] args) {
        System.out.println(maximumGain("aabbaaxybbaabb", 5, 4));
    }
}
