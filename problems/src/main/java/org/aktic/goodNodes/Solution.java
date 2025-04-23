package org.aktic.goodNodes;

import java.util.Map;

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
    public static int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public static int dfs(TreeNode root, int max) {
        if (root == null) return 0;

        int count = 0;
        if (root.val >= max) count = 1;

        max = Math.max(max, root.val);
        count += dfs(root.left, max);
        count += dfs(root.right, max);

        return count;
    }

    public static void main(String[] args) {
        // Sample Tree:
        //         3
        //        / \
        //       1   4
        //      /   / \
        //     3   1   5

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        int goodNodeCount = goodNodes(root);
        System.out.println("Number of good nodes: " + goodNodeCount);  // Output: 4
    }
}
