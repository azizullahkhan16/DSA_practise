package org.aktic.permute;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.list;

public class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // Base case: a permutation is complete.
            return;
        }

        for (int num : nums) {
            if (current.contains(num)) continue; // Skip duplicates.

            current.add(num); // Make a choice.
            backtrack(nums, current, result); // Explore further.
            current.remove(current.size() - 1); // Undo the choice.
        }
    }


    public static void main(String[] args) {
        System.out.println(permute(new int[] {1, 2, 3}));
    }
}
