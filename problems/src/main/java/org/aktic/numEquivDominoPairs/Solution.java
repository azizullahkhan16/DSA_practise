package org.aktic.numEquivDominoPairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < dominoes.length; i++) {
            String temp = String.valueOf(Math.min(dominoes[i][0], dominoes[i][1])) + Math.max(dominoes[i][0], dominoes[i][1]);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        int count = 0;
        for (int value : map.values()) {
            count += (value * (value - 1)) / 2;
        }

        return count;

    }

    public static void main(String[] args) {
        System.out.println(numEquivDominoPairs(new int[][]{{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}}));
    }
}
