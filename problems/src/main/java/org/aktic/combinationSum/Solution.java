package org.aktic.combinationSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        return dfs(0, new ArrayList<>(), 0, target, res, candidates);

    }

    private static List<List<Integer>> dfs(int index, List<Integer> curr, int total, int target, List<List<Integer>> res, int[] candidates) {
        if (total == target) {
            res.add(List.copyOf(curr));
            return res;
        }
        if (index >= candidates.length || total > target) {
            return res;
        }

        curr.add(candidates[index]);
        dfs(index, curr, total + candidates[index], target, res, candidates);
        curr.removeLast();
        return dfs(index + 1, curr, total, target, res, candidates);

    }

}
