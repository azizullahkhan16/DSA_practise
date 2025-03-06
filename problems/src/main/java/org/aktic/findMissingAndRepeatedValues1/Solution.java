package org.aktic.findMissingAndRepeatedValues1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        int n = grid.length;
        int[] res = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (set.contains(grid[i][j])) {
                    res[0] = grid[i][j];
                } else set.add(grid[i][j]);
            }
        }

        for (int i = 1; i <= n * n; i++) {
            if (!set.contains(i)) {
                res[1] = i;
                return res;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(new int[][]{{1, 3}, {2, 2}})));
    }
}
