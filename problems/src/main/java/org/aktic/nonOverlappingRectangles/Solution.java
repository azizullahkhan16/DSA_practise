package org.aktic.nonOverlappingRectangles;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    private int[][] rectangles;
    private int[] areaPrefixSum;
    private Random rand;

    public Solution(int[][] rects) {
        this.rectangles = rects;
        this.rand = new Random();

        areaPrefixSum = new int[rects.length];
        for (int i = 0; i < rects.length; i++) {
            int width = rects[i][2] - rects[i][0] + 1;
            int length = rects[i][3] - rects[i][1] + 1;
            int area = width * length;
            areaPrefixSum[i] = area + (i > 0 ? areaPrefixSum[i - 1] : 0);
        }
    }

    public int[] pick() {
        int totalArea = areaPrefixSum[areaPrefixSum.length - 1];
        int randArea = rand.nextInt(totalArea);

        int index = binarySearch(randArea);

        int bottom_x = rectangles[index][0];
        int bottom_y = rectangles[index][1];
        int width = rectangles[index][2] - rectangles[index][0] + 1;
        int length = rectangles[index][3] - rectangles[index][1] + 1;

        int random_x = bottom_x + rand.nextInt(width);
        int random_y = bottom_y + rand.nextInt(length);

        return new int[]{random_x, random_y};
    }

    private int binarySearch(int target) {
        int left = 0, right = areaPrefixSum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (areaPrefixSum[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[][] rects = {{-2, -2, 1, 1},
                        {2, 2, 4, 6}};

        Solution solution = new Solution(rects);
        System.out.println(Arrays.toString(solution.pick()));
    }
}
