package org.aktic.setZeroes;

import java.util.Arrays;

public class Solution {
    public static void setZeroes(int[][] matrix) {
        boolean[] rowZero = new boolean[matrix.length];
        boolean[] colZero = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    rowZero[i] = true;
                    colZero[j] = true;
                }
            }
        }

        for (int i = 0; i < rowZero.length; i++) {
            if(rowZero[i]) setRowZeroes(matrix, i);
        }

        for (int i = 0; i < colZero.length; i++) {
            if(colZero[i]) setColZeroes(matrix, i);
        }
    }

    public static void setRowZeroes(int[][] matrix, int row) {
        Arrays.fill(matrix[row], 0);
    }

    public static void setColZeroes(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }

    }

    public static void main(String[] args) {
        setZeroes(new int[][] {{1,1,1},{1,0,1},{1,1,1}});
    }
}
