package org.aktic.minDominoRotations;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int minDominoRotations(int[] tops, int[] bottoms) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < tops.length; i++) {
            map.put(tops[i], map.getOrDefault(tops[i], 0) + 1);
        }

        for (int i = 0; i < bottoms.length; i++) {
            map.put(bottoms[i], map.getOrDefault(bottoms[i], 0) + 1);
        }


        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= tops.length) {
                max = entry.getKey();
                break;
            }
        }

        if (max == Integer.MIN_VALUE) return -1;

        int topCount = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != max && bottoms[i] == max) topCount++;
            if (tops[i] != max && bottoms[i] != max) return -1;
        }

        int bottomCount = 0;

        for (int i = 0; i < bottoms.length; i++) {
            if (bottoms[i] != max && tops[i] == max) bottomCount++;
            if (tops[i] != max && bottoms[i] != max) return -1;
        }


        return Math.min(topCount, bottomCount);
    }

    public static void main(String[] args) {
        System.out.println(minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
    }
}
