package org.aktic.minimumStringLength;

import java.util.Stack;

class Solution {

    public static int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        char current;

        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(current);
                continue;
            }

            if (current == 'D' && stack.peek() == 'C') {
                stack.pop();
            }
            else if (current == 'B' && stack.peek() == 'A') {
                stack.pop();
            }
            else {
                stack.push(current);
            }
        }

        return stack.size();
    }
    public static void main(String[] args) {
        System.out.println(minLength("ABFCACDB"));
    }
}