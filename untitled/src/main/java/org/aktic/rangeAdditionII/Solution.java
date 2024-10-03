package org.aktic.rangeAdditionII;

import java.util.HashMap;
import java.util.Map;

public class Solution {
//    public static int maxCount(int m, int n, int[][] ops) {
//        if(ops.length == 0) return m*n;
//        int[][] res = new int[m][n];
////        int[] max = new int[2];
//
//        for (int i = 0; i < ops.length; i++) {
//            for (int k = 0; k < ops[i][0]; k++) {
//                for (int l = 0; l < ops[i][1]; l++) {
//                    res[k][l] += 1;
//                }
//            }
//        }
//
//        Map<Integer, Integer> max = new HashMap<>();
//        int num = 0;
//
//        for (int i = 0; i < res.length; i++) {
//            for (int j = 0; j < res[i].length; j++) {
//                max.put(res[i][j], max.getOrDefault(res[i][j], 0) + 1);
//                if(res[i][j] > num) num = res[i][j];
//            }
//        }
//
//        return max.getOrDefault(num, 0);
//
//    }

    public static int maxCount(int m, int n, int[][] ops) {
        if(ops.length == 0) return m*n;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (int i = 0; i < ops.length; i++) {
            minX = Math.min(minX, ops[i][0]);
            minY = Math.min(minY, ops[i][1]);
        }

        return minX + minY;
    }




    public static void main(String[] args) {
        int[][] ops = {{2,2},{3,3}};
        System.out.println(maxCount(3, 3, ops));
    }
}
