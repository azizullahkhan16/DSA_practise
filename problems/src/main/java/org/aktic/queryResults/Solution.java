package org.aktic.queryResults;

import java.util.*;

public class Solution {
    public static int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length];
        Map<Integer, Integer> ballToColors = new HashMap<>(); // Maps ball to its assigned color
        Map<Integer, Integer> colorCount = new HashMap<>(); // Maps color to its frequency

        int distinctColors = 0; // Count of unique colors

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0], color = queries[i][1];

            if (ballToColors.containsKey(ball)) {
                int oldColor = ballToColors.get(ball);

                // Decrease the count of the old color
                colorCount.put(oldColor, colorCount.get(oldColor) - 1);

                // If no more balls have this old color, remove it from distinct count
                if (colorCount.get(oldColor) == 0) {
                    colorCount.remove(oldColor);
                    distinctColors--;
                }
            }

            // Assign the new color to the ball
            ballToColors.put(ball, color);

            // Increase the count of the new color
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);

            // If this is the first time this color appears, increase distinct count
            if (colorCount.get(color) == 1) {
                distinctColors++;
            }

            result[i] = distinctColors;
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(queryResults(4, new int[][]{{1, 4}, {2, 5}, {1, 3}, {3, 4}})));
    }
}
