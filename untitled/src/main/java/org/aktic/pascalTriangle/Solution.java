package org.aktic.pascalTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> row = new ArrayList<>();
        row.add(1);
        result.add(row);

        for (int i = 1; i < numRows; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j == 0) {
                    row.add(j, 1);
                } else if(j > 0 && j < i){
                    row.add(j, result.get(i-1).get(j-1) + result.get(i-1).get(j));
                } else {
                    row.add(j, 1);
                }
            }
            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
