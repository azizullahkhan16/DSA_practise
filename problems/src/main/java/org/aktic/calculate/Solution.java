package org.aktic.calculate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static int calculate(String s) {
        s = s.replaceAll("\\s+", "");
        String[] tokens = s.split("(?<=[-+*/])|(?=[-+*/])");
        if (tokens.length == 0) return 0;
        if (tokens.length == 1) return Integer.parseInt(tokens[0]);

        LinkedList<Integer> stack = new LinkedList<>();
        int currentNumber = 0;
        char operation = '+';

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                currentNumber = Integer.parseInt(token);
            } else {
                switch (operation) {
                    case '+':
                        stack.push(currentNumber);
                        break;
                    case '-':
                        stack.push(-currentNumber);
                        break;
                    case '*':
                        stack.push(stack.pop() * currentNumber);
                        break;
                    case '/':
                        stack.push(stack.pop() / currentNumber);
                        break;
                }
                operation = token.charAt(0);
                currentNumber = 0;
            }
        }

        // Process the last number
        switch (operation) {
            case '+':
                stack.push(currentNumber);
                break;
            case '-':
                stack.push(-currentNumber);
                break;
            case '*':
                stack.push(stack.pop() * currentNumber);
                break;
            case '/':
                stack.push(stack.pop() / currentNumber);
                break;
        }

        // Sum up all the numbers in the stack
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+5/7"));
    }
}
