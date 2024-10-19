package org.aktic.NeighborSum;

public class NeighborSum {

    private int[][] grid;

    public NeighborSum(int[][] grid) {
        this.grid = grid;
    }

    public int adjacentSum(int value) {
        int sum = 0;

        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid.length; j++) {
                if(this.grid[i][j] == value) {
                    if(i-1 >=0) sum += this.grid[i-1][j];
                    if(i+1 < this.grid.length) sum += this.grid[i+1][j];
                    if(j-1 >=0) sum += this.grid[i][j-1];
                    if(j+1 < this.grid.length) sum += this.grid[i][j+1];
                    break;
                }
            }
        }

        return sum;
    }

    public int diagonalSum(int value) {
        int sum = 0;

        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid.length; j++) {
                if(this.grid[i][j] == value) {
                    if(i-1 >=0 && j-1 >= 0) sum += this.grid[i-1][j-1];
                    if(i-1 >= 0 && j+1 < this.grid.length) sum += this.grid[i-1][j+1];
                    if(i+1 < grid.length && j-1 >=0) sum += this.grid[i+1][j-1];
                    if(i+1 < this.grid.length && j+1 < this.grid.length) sum += this.grid[i+1][j+1];
                    break;
                }
            }
        }

        return sum;
    }
}

