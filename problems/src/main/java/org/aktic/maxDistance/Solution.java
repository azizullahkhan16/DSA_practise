package org.aktic.maxDistance;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int maxDistance(String s, int k) {
        int num1 = updateStringAndReturnMax("NE", s, k);
        int num2 = updateStringAndReturnMax("NW", s, k);
        int num3 = updateStringAndReturnMax("SE", s, k);
        int num4 = updateStringAndReturnMax("SW", s, k);

        return Math.max(Math.max(num1, num2), Math.max(num3, num4));

    }

    public static int updateStringAndReturnMax(String direction, String s, int k) {
        char c1 = direction.charAt(0);
        char c2 = direction.charAt(1);
        int count = 0;
        int max = 0;

        for (char c : s.toCharArray()) {
            if ((c == 'N' || c == 'S') && c != c1 && k != 0) {
                count++;
                k--;
            } else if ((c == 'E' || c == 'W') && c != c2 && k != 0) {
                count++;
                k--;
            } else {
                if (c == c1 || c == c2) count++;
                else count--;
            }

            max = Math.max(max, count);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxDistance("NWSE", 1));
    }
}
