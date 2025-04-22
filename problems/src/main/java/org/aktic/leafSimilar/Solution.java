package org.aktic.leafSimilar;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;

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
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leaves1 = findLeaves(root1, new ArrayList<>());
        ArrayList<Integer> leaves2 = findLeaves(root2, new ArrayList<>());

        return leaves1.equals(leaves2);
    }

    public static ArrayList<Integer> findLeaves(TreeNode root, ArrayList<Integer> leaves) {
        if (root == null) return leaves;

        if (root != null && root.left == null && root.right == null) {
            leaves.add(root.val);
        }

        findLeaves(root.left, leaves);
        findLeaves(root.right, leaves);

        return leaves;

    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);

        // Tree 2
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        System.out.println(leafSimilar(root1, root2));
    }
}
