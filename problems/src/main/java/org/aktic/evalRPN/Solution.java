package org.aktic.evalRPN;

import java.util.Stack;

public class Solution {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a, b;

        for(String token : tokens) {
            switch(token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.parseInt(token));

            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
    }
}
