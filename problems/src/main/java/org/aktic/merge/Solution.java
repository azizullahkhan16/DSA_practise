package org.aktic.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();

        boolean prevMerged = false;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= intervals[i-1][1]) {
                merged.add(new int[] {intervals[i-1][0], Math.max(intervals[i][1], intervals[i-1][1])});
                prevMerged = true;
            }else {
                if(prevMerged) {
                    prevMerged = false;
                }else {
                    merged.add(new int[] {intervals[i - 1][0], intervals[i - 1][1]});
                }
            }
        }
        if(!prevMerged) {
            merged.add(new int[] {intervals[intervals.length-1][0], intervals[intervals.length-1][1]});
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1,4}, {0,2}, {3,5}})));
    }
}
