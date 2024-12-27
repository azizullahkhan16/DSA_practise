package org.aktic.calPoints;

import java.util.Stack;

public class Solution {
    public static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            switch (op) {
                case "+":
                    int num1 = stack.pop();
                    int res = stack.peek() + num1;
                    stack.push(num1);
                    stack.push(res);
                    break;
                case "D":
                    stack.push(stack.peek()*2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(op));
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(calPoints(new String[] { "5","2","C","D","+"}));
    }
}
