package org.aktic.isMonotonic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Solution {
    public static boolean isMonotonic(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            if(!stack.isEmpty()) {
                if(stack.peek() <= nums[i]) {
                    stack.push(nums[i]);
                }else break;
            }else stack.push(nums[i]);
        }

        if(stack.size() == nums.length) return true;
        else {
            stack.clear();

            for (int i = 0; i < nums.length; i++) {
                if(!stack.isEmpty()) {
                    if(stack.peek() >= nums[i]) {
                        stack.push(nums[i]);
                    }else break;
                }else stack.push(nums[i]);
            }

            if(stack.size() == nums.length) return true;
            else return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{6,5,4,4}));
    }
}
