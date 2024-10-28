package org.aktic.dailyTemperatures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
//    public static int[] dailyTemperatures(int[] temperatures) {
//        Stack<Integer> stack = new Stack<>();
//        int[] result = new int[temperatures.length];
//        int count = 0;
//        boolean isFound = false;
//
//        for (int i = 0; i < temperatures.length; i++) {
//            stack.push(temperatures[i]);
//
//            for (int j = i+1; j < temperatures.length; j++) {
//                if(stack.peek() < temperatures[j]) {
//                    isFound = true;
//                    count++;
//                    break;
//                }
//                count++;
//            }
//            stack.pop();
//            if(isFound) result[i] = count;
//            isFound = false;
//            count = 0;
//        }
//
//        return result;
//
//    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
