package org.aktic.FindElements;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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

public class FindElements {

    private Set<Integer> set;

    public FindElements(TreeNode root) {
        this.set = new HashSet<>();

        Queue<TreeNode> queue = new LinkedList<>();

        root.val = 0;
        set.add(0);

        if (root.left != null) {
            int temp = (2 * root.val) + 1;
            root.left.val = temp;
            set.add(temp);
            queue.add(root.left);
        }
        if (root.right != null) {
            int temp = (2 * root.val) + 2;
            root.right.val = temp;
            set.add(temp);
            queue.add(root.right);
        }

        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();

            if (tempNode.left != null) {
                int temp = (2 * tempNode.val) + 1;
                tempNode.left.val = temp;
                set.add(temp);
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                int temp = (2 * tempNode.val) + 2;
                tempNode.right.val = temp;
                set.add(temp);
                queue.add(tempNode.right);
            }

        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}