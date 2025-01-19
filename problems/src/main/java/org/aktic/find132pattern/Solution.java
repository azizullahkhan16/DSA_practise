package org.aktic.find132pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
//    public static boolean find132pattern(int[] nums) {
//        if(nums.length < 3) return false;
//
//        List<Integer> list = new ArrayList<>();
//        list.add(nums[0]);
//
//        for(int i = 1; i < nums.length; i++) {
//            if(list.size() == 1 && list.get(0) < nums[i]) {
//                list.add(nums[i]);
//            }else if(list.size() == 1 && list.get(0) > nums[i]) {
//                list.remove(0);
//                list.add(nums[i]);
//            }else if(list.size() == 2 && list.get(1) < nums[i]) {
//                list.remove(1);
//                list.add(nums[i]);
//            }else if(list.size() == 2 && list.get(1) > nums[i]) {
//                if(list.get(0) < nums[i]) {
//                    return true;
//                }else {
//                    list.clear();
//                    list.add(nums[i]);
//                }
//            }
//        }
//
//        return false;
//    }

    public static boolean find132pattern(int[] nums) {
        // If the array has fewer than 3 elements, it's impossible to have a 132 pattern.
        if (nums.length < 3) return false;

        // Stack to help find the "3" in the 132 pattern.
        Stack<Integer> stack = new Stack<>();
        // Variable to keep track of the "2" in the 132 pattern.
        // Initialize it with the smallest possible value to start.
        int third = Integer.MIN_VALUE;

        // Traverse the array from right to left.
        for (int i = nums.length - 1; i >= 0; i--) {
            // If the current number is less than the "third" element,
            // we've found a valid "1" in the 132 pattern.
            if (nums[i] < third) {
                return true;
            }

            // While there are elements in the stack and the current number
            // is greater than the element at the top of the stack:
            // This means we are finding a new potential "3" for the pattern.
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                // Pop the stack and update the "third" element to the last popped value.
                // This is the largest element smaller than nums[i], which acts as "2".
                third = stack.pop();
            }

            // Push the current number onto the stack.
            // This number is a potential "3" for future iterations.
            stack.push(nums[i]);
        }

        // If no 132 pattern was found, return false.
        return false;
    }


    public static void main(String[] args) {
        System.out.println(find132pattern(new int[] {3,5,0,3,4}));
    }
}
