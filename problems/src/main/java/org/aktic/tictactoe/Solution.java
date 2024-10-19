package org.aktic.tictactoe;

class Solution {
    public static String tictactoe(int[][] moves) {
        int[][] board = new int[3][3];

        // 0 represents Empty
        // 1 represents X
        // 2 represents O

        for (int i = 0; i < moves.length; i++) {
            if(i%2 == 0) board[moves[i][0]][moves[i][1]] = 1;
            else board[moves[i][0]][moves[i][1]] = 2;
        }

        // check rows for winner
        for (int i = 0; i < board.length; i++) {
            if(board[i][0] == 1 && board[i][1] == 1 && board[i][2] == 1) return "A";
            else if(board[i][0] == 2 && board[i][1] == 2 && board[i][2] == 2) return "B";
        }

        // check cols for winner
        for (int i = 0; i < board.length; i++) {
            if(board[0][i] == 1 && board[1][i] == 1 && board[2][i] == 1) return "A";
            else if(board[0][i] == 2 && board[1][i] == 2 && board[2][i] == 2) return "B";
        }

        // check diagonals for winner
        if(board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1) return "A";
        else if(board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2) return "B";

        if(board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1) return "A";
        else if(board[0][2] == 2 && board[1][1] == 2 && board[2][0] == 2) return "B";

        // check for pending game
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == 0) return "Pending";
            }
        }

        return "Draw";
    }

    public static void main(String[] args) {
        int[][] moves = {{0,0},{2,0},{1,1},{2,1},{2,2}};
        System.out.println(tictactoe(moves));
    }
}
