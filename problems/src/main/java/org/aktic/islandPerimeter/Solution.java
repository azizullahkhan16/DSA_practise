package org.aktic.islandPerimeter;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int islandPerimeter(int[][] grid) {
        Queue<Integer[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    q.add(new Integer[]{i, j});
                    grid[i][j] = 2;
                    break;
                }
            }
            if(!q.isEmpty()) break;
        }
        int perimeter = 0;

        while(!q.isEmpty()) {
            Integer[] arr = q.poll();
            int row = arr[0];
            int col = arr[1];

            if (row - 1 < 0 || grid[row - 1][col] == 0) perimeter++;
            else if(grid[row-1][col] == 1) q.add(new Integer[]{row - 1, col});
            // Check bottom neighbor
            if (row + 1 >= grid.length || grid[row + 1][col] == 0) perimeter++;
            else if(grid[row+1][col] == 1) q.add(new Integer[]{row + 1, col});
            // Check left neighbor
            if (col - 1 < 0 || grid[row][col - 1] == 0) perimeter++;
            else if(grid[row][col-1] == 1) q.add(new Integer[]{row, col - 1});
            // Check right neighbor
            if (col + 1 >= grid[row].length || grid[row][col + 1] == 0) perimeter++;
            else if(grid[row][col+1] == 1) q.add(new Integer[]{row, col + 1});

            grid[row][col] = 2;
        }
        return perimeter;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }
}
