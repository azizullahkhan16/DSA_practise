package org.aktic.deleteNode;

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
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key); // Go left
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key); // Go right
        } else {
            // Node to be deleted found

            // Case 1: No children
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3: Two children
            TreeNode successor = findMin(root.right); // in-order successor
            root.val = successor.val; // Copy value
            root.right = deleteNode(root.right, successor.val); // Delete successor
        }

        return root;
    }

    private static TreeNode findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

}
