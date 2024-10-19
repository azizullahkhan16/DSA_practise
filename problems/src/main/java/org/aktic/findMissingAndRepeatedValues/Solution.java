package org.aktic.findMissingAndRepeatedValues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int a = -1, b = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < grid.length* grid.length; i++) {
            map.put(i+1, 0);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) + 1);
                if (map.get(grid[i][j]) > 1) a = grid[i][j];
            }
        }

        for(int key : map.keySet()) {
            if (map.get(key) == 0) b = key;
        }


        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3},{2,2}};
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid)));
    }
}
