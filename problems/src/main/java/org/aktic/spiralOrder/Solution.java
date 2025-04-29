package org.aktic.spiralOrder;

import java.util.ArrayList;
import java.util.List;

public class Solution {
//    public static List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> list = new ArrayList<>();
//
//        if (matrix == null || matrix.length == 0) return list;
//
//        int top = 0;
//        int bottom = matrix.length - 1;
//        int left = 0;
//        int right = matrix[0].length - 1;
//
//        while (top <= bottom && left <= right) {
//
//            for (int j = left; j <= right; j++) {
//                list.add(matrix[top][j]);
//            }
//            top++;
//
//            for (int i = top; i <= bottom; i++) {
//                list.add(matrix[i][right]);
//            }
//            right--;
//
//            if (top <= bottom) {
//                for (int j = right; j >= left; j--) {
//                    list.add(matrix[bottom][j]);
//                }
//                bottom--;
//            }
//
//            if (left <= right) {
//                for (int i = bottom; i >= top; i--) {
//                    list.add(matrix[i][left]);
//                }
//                left++;
//            }
//        }
//
//        return list;
//    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int left = 0;
        int right = matrix.length - 1;
        int top = 0;
        int bottom = matrix[0].length - 1;


        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
