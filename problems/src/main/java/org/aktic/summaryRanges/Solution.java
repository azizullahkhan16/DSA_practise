package org.aktic.summaryRanges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> summaryRanges(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        int prev = nums[0];
        int index = 0;
        List<String> ranges = new ArrayList<String>();

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]+1) {
                if(index == i-1) ranges.add(String.valueOf(prev));
                else ranges.add(prev+"->"+nums[i-1]);
                prev = nums[i];
                index = i;
            }
        }

        if(index == nums.length-1) ranges.add(String.valueOf(prev));
        else ranges.add(prev+"->"+nums[nums.length-1]);

        return ranges;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));
    }
}

