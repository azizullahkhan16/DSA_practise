package org.aktic.numberOfPoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Solution {
    public static int numberOfPoints(List<List<Integer>> nums) {
        // Sort intervals based on their start times
        nums.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));

        List<List<Integer>> res = new ArrayList<>();
        int count = 0;

        // Initialize the count with the length of the first interval
        count = nums.get(0).get(1) - nums.get(0).get(0) + 1;
        res.add(new ArrayList<>(nums.get(0)));

        for (int i = 1; i < nums.size(); i++) {
            // Get the last interval in the result
            List<Integer> last = res.get(res.size() - 1);

            // If the intervals overlap
            if (last.get(1) >= nums.get(i).get(0)) {
                if(last.get(1) >= nums.get(i).get(1)) continue;
                // Calculate the additional count
                count += nums.get(i).get(1) - Math.max(nums.get(i).get(0), last.get(1));
                // Merge intervals
                last.set(1, Math.max(last.get(1), nums.get(i).get(1)));
            } else {
                // Non-overlapping interval, add to result
                count += nums.get(i).get(1) - nums.get(i).get(0) + 1;
                res.add(new ArrayList<>(nums.get(i)));
            }
        }

        return count;
    }


    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(2, 5));
        nums.add(Arrays.asList(3, 8));
        nums.add(Arrays.asList(1, 6));
        nums.add(Arrays.asList(4, 10));
        System.out.println(numberOfPoints(nums));
    }
}
