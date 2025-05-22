package org.aktic.maxRemoval;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> available = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> assigned = new PriorityQueue<>();
        int count = 0;
        for (int time = 0, k = 0; time < nums.length; time++) {
            while (!assigned.isEmpty() && assigned.peek() < time)
                assigned.poll();
            while (k < queries.length && queries[k][0] <= time)
                available.add(queries[k++][1]);
            while (assigned.size() < nums[time]
                    && !available.isEmpty()
                    && available.peek() >= time) {
                assigned.add(available.poll());
                count++;
            }
            if (assigned.size() < nums[time])
                return -1;
        }
        return queries.length - count;
    }

    public static void main(String[] args) {
        System.out.println(maxRemoval(new int[]{1, 1, 1, 1}, new int[][]{{1, 3}, {0, 2}, {1, 3}, {1, 2}}));
    }
}
