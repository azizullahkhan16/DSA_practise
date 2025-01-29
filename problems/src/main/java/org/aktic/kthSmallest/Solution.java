package org.aktic.kthSmallest;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static int kthSmallest(int[][] matrix, int k) {
        Arrays.sort(matrix, (row1, row2) -> Integer.compare(row1[0], row2[0]));

        PriorityQueue<Integer> minHeapDescending = new PriorityQueue<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                minHeapDescending.add(matrix[i][j]);
            }
        }

        while (!minHeapDescending.isEmpty()) {
            k--;
            if(k == 0 ) return minHeapDescending.poll();
            minHeapDescending.poll();
        }


        return -1;


    }

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[][] {{1,2}, {1,3}}, 4));
    }
}
