package org.aktic.minTimeToVisitAllPoints;

public class Solution {
    public static int minTimeToVisitAllPoints(int[][] points) {
        int count = 0;

        for (int i = 1; i < points.length; i++) {
            int prevX = points[i - 1][0];
            int prevY = points[i - 1][1];
            int currX = points[i][0];
            int currY = points[i][1];

            int resX = Math.abs(currX - prevX);
            int resY = Math.abs(currY - prevY);

            count += Math.max(resX, resY);
        }

        return count;
    }
}
