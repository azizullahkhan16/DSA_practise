package org.aktic.checkValid;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean checkValid(int[][] matrix) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                map.put(matrix[i][j], map.getOrDefault(matrix[i][j], 0) + 1);
                map1.put(matrix[j][i], map1.getOrDefault(matrix[j][i], 0) + 1);

                if(map.get(matrix[i][j]) > 1 || map1.get(matrix[j][i]) > 1) return false;
            }
            map.clear();
            map1.clear();
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{3,1,2},{2,3,1}};
        System.out.println(checkValid(matrix));
    }
}
