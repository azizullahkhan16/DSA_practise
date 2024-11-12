package org.aktic.gameOfLife;

public class Solution {
    public static void gameOfLife(int[][] board) {
        int[][] newState = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int numOnes = 0;
                if(i-1 >= 0 && j-1 >= 0 && board[i-1][j-1] == 1) numOnes++;
                if(i-1 >= 0 && board[i-1][j] == 1) numOnes++;
                if(i-1 >= 0 && j+1 < board[i].length && board[i-1][j+1] == 1) numOnes++;
                if(j+1 < board[i].length && board[i][j+1] == 1) numOnes++;
                if(i+1 < board.length && j+1 < board[i].length && board[i+1][j+1] == 1) numOnes++;
                if(i+1 < board.length && board[i+1][j] == 1) numOnes++;
                if(i+1 < board.length && j-1 >= 0 && board[i+1][j-1] == 1) numOnes++;
                if(j-1 >= 0 && board[i][j-1] == 1) numOnes++;

                if(numOnes < 2 && board[i][j] == 1) newState[i][j] = 0;
                else if(numOnes <= 3 && board[i][j] == 1) newState[i][j] = 1;
                else if(numOnes > 3 && board[i][j] == 1) newState[i][j] = 0;
                else if(numOnes == 3 && board[i][j] == 0) newState[i][j] = 1;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = newState[i][j];
            }
        }
    }

    public static void main(String[] args) {
        gameOfLife(new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        });
    }
}
