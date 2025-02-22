package org.aktic.recoverFromPreorder;

import java.util.ArrayList;
import java.util.LinkedList;
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
    public static TreeNode recoverFromPreorder(String traversal) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        int dashes = 0;
        int i = 0;

        while (i < traversal.length()) {
            if (traversal.charAt(i) == '-') {
                dashes++;
                i++;
            } else {
                int j = i;
                while (j < traversal.length() && traversal.charAt(j) != '-') {
                    j++;
                }

                int val = Integer.parseInt(traversal.substring(i, j));
                TreeNode node = new TreeNode(val);

                while (stack.size() > dashes) stack.removeLast();

                if (!stack.isEmpty()) {
                    if (stack.getLast().left == null) stack.getLast().left = node;
                    else stack.getLast().right = node;
                }

                stack.addLast(node);
                i = j;
                dashes = 0;
            }
        }

        return stack.getFirst();
    }

    public static void main(String[] args) {

    }
}
