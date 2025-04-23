package org.aktic.searchBST;

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
    public static TreeNode searchBST(TreeNode root, int val) {
        TreeNode temp = root;
        while (true) {
            if (temp == null) break;

            int num = temp.val;

            if (num == val) return temp;
            else if (num > val) temp = temp.left;
            else temp = temp.right;
        }

        return null;
    }

    public static void main(String[] args) {
        /*
            BST Structure:
                    8
                   / \
                  3   10
                 / \    \
                1   6    14
                   / \   /
                  4   7 13
        */

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        int searchVal = 6;
        TreeNode result = searchBST(root, searchVal);
        System.out.println(result);
    }
}
