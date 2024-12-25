package org.aktic.maxSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int[] maxSubsequence(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();

        for(int num: nums) {
            numList.add(num);
        }

        for (int i = 0; i < nums.length-k; i++) {
            int leastIndex = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < numList.size(); j++) {
                if(numList.get(j) < min) {
                    min = numList.get(j);
                    leastIndex = j;
                }
            }
            numList.remove(leastIndex);
        }

        int[] result = new int[numList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = numList.get(i);
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSubsequence(new int[]{2, 1, 3, 3}, 2)));
    }
}
