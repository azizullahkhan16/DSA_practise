package org.aktic.hIndex;

import java.util.Arrays;
import java.util.Map;

public class Solution {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int max = 0;

        for (int i = 0; i < citations.length; i++) {
            if(citations[i] >= citations.length-i) {
                if(citations.length-i > max) {
                    max = citations.length-i;
                }
            }
        }

        return max;
    }


    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{3,0,6,1,5}));
    }
}
