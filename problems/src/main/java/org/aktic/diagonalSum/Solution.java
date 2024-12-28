package org.aktic.diagonalSum;

public class Solution {
    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        boolean isOdd = false;

        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
        }

        if(mat.length % 2 != 0) isOdd = true;

        for (int i = 0; i < mat.length; i++) {
            if(isOdd && i == mat.length / 2) continue;
            sum += mat[i][mat.length - i - 1];
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
