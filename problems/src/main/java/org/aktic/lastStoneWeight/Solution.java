package org.aktic.lastStoneWeight;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();

            if (stone1 != stone2) pq.offer(Math.max(stone1, stone2) - Math.min(stone1, stone2));
        }


        return pq.size() == 1 ? pq.poll() : 0;
    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }
}
