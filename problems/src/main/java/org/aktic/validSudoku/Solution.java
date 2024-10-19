package org.aktic.validSudoku;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean isValidSudoku(char[][] board) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();

        // checking all the rows first
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] != '.') {
                    frequency.put(board[i][j], frequency.getOrDefault(board[i][j], 0) + 1);
                    if(frequency.get(board[i][j]) > 1) {
                        return false;
                    }
                }
            }
            frequency.clear();
        }

        // checking all the cols first
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[j][i] != '.') {
                    frequency.put(board[j][i], frequency.getOrDefault(board[j][i], 0) + 1);
                    if(frequency.get(board[j][i]) > 1) {
                        return false;
                    }
                }
            }
            frequency.clear();
        }

        // checking all 3x3 boxes
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                frequency.clear();  // Clear for each box

                // Loop through each cell in the 3x3 box
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char current = board[boxRow * 3 + i][boxCol * 3 + j];
                        if (current != '.') {
                            frequency.put(current, frequency.getOrDefault(current, 0) + 1);
                            if (frequency.get(current) > 1) {
                                return false;  // Duplicate found in the 3x3 box
                            }
                        }
                    }
                }
            }
        }


        return true;

    }


    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '5', '1', '9', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }
}
