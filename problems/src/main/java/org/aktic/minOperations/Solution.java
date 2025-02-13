package org.aktic.minOperations;

import java.util.PriorityQueue;

public class Solution {
    public static int minOperations(int[] nums, int k) {
        if (nums.length < 2) return 0;

        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.add((long) num);
        }

        int count = 0;

        while (queue.peek() < k) {
            Long num1 = queue.poll();
            Long num2 = queue.poll();
            Long res = (Math.min(num1, num2) * 2) + Math.max(num1, num2);
            queue.add(res);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{999999999, 999999999, 999999999}, 1000000000));
    }
}
