package org.aktic.pathSum2;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0, new ArrayList<>(), new ArrayList<>());
    }

    public static List<List<Integer>> dfs(TreeNode root, int targetSum, int currSum, List<Integer> currList, List<List<Integer>> res) {
        if (root == null) return res;

        currList.add(root.val);
        currSum += root.val;

        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                res.add(new ArrayList<>(currList));
            }
        }

        dfs(root.left, targetSum, currSum, currList, res);
        dfs(root.right, targetSum, currSum, currList, res);

        currList.remove(currList.size() - 1);

        return res;
    }
}
