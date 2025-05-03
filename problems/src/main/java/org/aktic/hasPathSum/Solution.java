package org.aktic.hasPathSum;

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
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    public static boolean dfs(TreeNode node, int sum, int targetSum) {
        if (node == null) return false;

        sum += node.val;

        // Check if it's a leaf node and the sum matches
        if (node.left == null && node.right == null) {
            return sum == targetSum;
        }

        return dfs(node.left, sum, targetSum) || dfs(node.right, sum, targetSum);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        hasPathSum(root, 22);
    }
}
