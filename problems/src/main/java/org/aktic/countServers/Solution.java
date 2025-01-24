package org.aktic.countServers;

public class Solution {
//    public static int countServers(int[][] grid) {
//        boolean[] rows = new boolean[grid.length];
//        boolean[] cols = new boolean[grid[0].length];
//
//        for (int i = 0; i < grid.length; i++) {
//            int count = 0;
//            for (int j = 0; j < grid[0].length; j++) {
//                count += grid[i][j];
//            }
//            if(count > 1) rows[i] = true;
//        }
//
//        for (int i = 0; i < grid[0].length; i++) {
//            int count = 0;
//            for (int j = 0; j < grid.length; j++) {
//                count += grid[j][i];
//            }
//            if(count > 1) cols[i] = true;
//        }
//
//        int temp = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if(grid[i][j] == 1 && (rows[i] || cols[j])) temp++;
//            }
//        }
//
//        return temp;
//
//    }

    public static int countServers(int[][] grid) {
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                rows[i] += grid[i][j];
                cols[j] += grid[i][j];
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1)) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countServers(new int[][] {{1, 0},
                {1, 1}}));
    }
}
