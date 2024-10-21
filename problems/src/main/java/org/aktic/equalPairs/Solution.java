package org.aktic.equalPairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int equalPairs(int[][] grid) {
        Map<Integer, Integer[]> rows = new HashMap<>();
        Map<Integer, Integer[]> cols = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            rows.put(i, convertToIntegerArray(grid[i]));
        }

        for (int j = 0; j < grid[0].length; j++) {
            Integer[] column = new Integer[grid.length];
            for (int i = 0; i < grid.length; i++) {
                column[i] = grid[i][j];  // Extract column elements
            }
            cols.put(j, column);
        }

        int count = 0;
        // Compare each row with every column
        for (int i : rows.keySet()) {
            for (int j : cols.keySet()) {
                if (Arrays.equals(rows.get(i), cols.get(j))) {
                    count++;
                }
            }
        }

        return count;
    }

    private static Integer[] convertToIntegerArray(int[] arr) {
        Integer[] result = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{3,2,1},{1,7,6},{2,7,7}};
        System.out.println(equalPairs(grid));
    }
}
