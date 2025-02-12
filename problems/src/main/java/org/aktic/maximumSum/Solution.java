package org.aktic.maximumSum;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int sum = sumOfDigits(nums[i]);
            if (map.containsKey(sum)) {
                PriorityQueue<Integer> queue = map.get(sum);
                queue.add(nums[i]);
                map.put(sum, queue);
            } else {
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                pq.add(nums[i]);
                map.put(sum, pq);

            }
        }

        int max = -1;

        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                PriorityQueue<Integer> queue = entry.getValue();
                int num1 = queue.poll();
                int num2 = queue.poll();
                max = Math.max(max, num1 + num2);
            }
        }

        return max;

    }

    public static int sumOfDigits(int num) {
        int sum = 0;
        num = Math.abs(num); // Handle negative numbers

        while (num > 0) {
            sum += num % 10; // Extract the last digit and add to sum
            num /= 10;       // Remove the last digit
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{18, 43, 36, 13, 7}));
    }
}
