package org.aktic.removeStars;

import java.util.Stack;

class Solution {
    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*' && !stack.empty()) {
                stack.pop();
            }else stack.push(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
    }
}