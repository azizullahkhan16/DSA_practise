package org.aktic.findMinArrowShots;

import java.util.Arrays;

public class Solution {
    public static int findMinArrowShots(int[][] points) {
        if(points.length == 1) return 1;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int left = 0, right = 1;
        int count = 0;

        while(left < points.length && right < points.length) {
            if(points[left][1] < points[right][0]) {
                count++;
                left = right;
                right++;
            }else if(points[left][1] >= points[right][0]) {
                right++;
            }
        }

        return ++count;

    }

    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{1, 2},{2, 3},{3, 4},{4, 5}}));
    }

}
