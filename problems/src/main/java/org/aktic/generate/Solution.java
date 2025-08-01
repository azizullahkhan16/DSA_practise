package org.aktic.generate;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    res.get(i).add(1);
                } else {
                    res.get(i).add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
