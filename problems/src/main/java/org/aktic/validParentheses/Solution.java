package org.aktic.validParentheses;

import java.util.Stack;

public class Solution {
    public static boolean isValid(String s) {
        if(s.length() == 1) return false;
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            if(c == ')' || c == '}' || c == ']') {
                if(!stack.isEmpty()) {
                    char p = stack.peek();
                    if((p == '(' && c == ')') || (p == '{' && c == '}') || (p == '[' && c == ']')) {
                        stack.pop();
                    } else return false;
                } else return false;
            }
        }

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        String s = ")(){}";

        System.out.println(isValid(s));
    }
}
