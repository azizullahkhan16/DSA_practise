package org.aktic.asteroidCollision;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if(stack.isEmpty()) {
                stack.push(asteroids[i]);
            }else {
                while(!stack.isEmpty()) {
                    if(stack.peek() < 0 && asteroids[i] < 0 || stack.peek() > 0 && asteroids[i] > 0 || stack.peek() < 0 && asteroids[i] > 0) {
                        stack.push(asteroids[i]);
                        break;
                    }else if(stack.peek() > 0 && asteroids[i] < 0) {
                        if(Math.abs(asteroids[i]) == Math.abs(stack.peek())) {
                            stack.pop();
                            break;
                        } else if(Math.abs(asteroids[i]) > Math.abs(stack.peek())) {
                            stack.pop();
                            if(stack.isEmpty()) {
                                stack.push(asteroids[i]);
                                break;
                            }
                        } else break;
                    }
                }

            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length-1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2,-2,1,-1})));
    }
}
