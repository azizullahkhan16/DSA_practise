package org.aktic.removeDuplicateLetters;

import java.util.*;

public class Solution {
    public static String removeDuplicateLetters(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        Stack<Character> stack = new Stack<>();
        Set<Character> inStack = new HashSet<>();

        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.get(c) - 1);

            if (inStack.contains(c)) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c && countMap.get(stack.peek()) > 0) {

                inStack.remove(stack.pop());
            }

            stack.push(c);
            inStack.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcaba"));
    }


}
