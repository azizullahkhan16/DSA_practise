package org.aktic.matrixReshape;

import java.util.Arrays;

class Solution {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length * mat[0].length != r * c) return mat;

        int[][] res = new int[r][c];

        int row = 0, col = 0;


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                res[row][col] = mat[i][j];
                if(col < res[row].length-1)col++;
                else {
                    row++;
                    col = 0;
                }

            }
        }

        return res;
    }


    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4}};
        System.out.println(Arrays.deepToString(matrixReshape(mat, 2, 2)));
    }
}