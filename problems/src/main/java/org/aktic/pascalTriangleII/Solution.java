package org.aktic.pascalTriangleII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<Integer> getRow(int rowIndex) {
        Integer[] res = new Integer[rowIndex + 1];
        Integer[] prev = new Integer[1];
        Integer[] curr = new Integer[1];
        curr[0] = 1;

        for (int i = 0; i <= rowIndex; i++) {
            if(i == 0) {
                prev[0] = 1;
                continue;
            }
            curr = new Integer[i+1];
            for (int j = 0; j < (i/2)+1; j++) {
                if(j == 0) {
                    curr[j] = 1;
                    curr[curr.length-1] = 1;
                    continue;
                }
                curr[j] = prev[j-1] + prev[j];
                curr[curr.length-1-j] = curr[j];
            }
            prev = curr;
        }

        return Arrays.asList(curr);
    }

    public static void main(String[] args) {
        System.out.println(getRow(0));
    }
}
