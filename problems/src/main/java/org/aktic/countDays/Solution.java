package org.aktic.countDays;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static int countDays(int days, int[][] meetings) {
        int freeDays = 0, latestEnd = 0;

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            if (start > latestEnd + 1) {
                freeDays += start - latestEnd - 1;
            }

            latestEnd = Math.max(latestEnd, end);
        }

        freeDays += days - latestEnd;

        return freeDays;
    }

    public static void main(String[] args) {
        System.out.println(countDays(10, new int[][]{{5, 7}, {1, 3}, {9, 10}}));
    }
}
