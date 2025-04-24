package org.aktic.colorCoord;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution {
    int[] solution(int length, int[][] queries) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int coord = queries[i][0];
            int color = queries[i][1];

            map.put(coord, color);
            res[i] = countConsecutive(map);
        }

        return res;
    }

    int countConsecutive(TreeMap<Integer, Integer> map) {
        int count = 0;
        Integer prevCoord = null;
        Integer prevColor = null;

        for (var entry : map.entrySet()) {
            int currCoord = entry.getKey();
            int currColor = entry.getValue();

            if (prevCoord != null && prevCoord + 1 == currCoord && prevColor.equals(currColor)) {
                count++;
            }

            prevCoord = currCoord;
            prevColor = currColor;
        }

        return count;
    }
}
