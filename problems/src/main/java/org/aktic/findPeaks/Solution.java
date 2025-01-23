package org.aktic.findPeaks;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> findPeaks(int[] mountain) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < mountain.length-1; i++) {
            if(mountain[i-1] < mountain[i] && mountain[i+1] < mountain[i]) {
                list.add(i);
            }
        }

        return list;
    }
}
