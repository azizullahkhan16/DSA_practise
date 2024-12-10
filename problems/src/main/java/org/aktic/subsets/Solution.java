package org.aktic.subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(0, new ArrayList<>(), res, nums);
        return res;

    }

    private static void backTrack(int start, List<Integer> current, List<List<Integer>> res, int[] nums) {
        res.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backTrack(i + 1, current, res, nums);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

}
