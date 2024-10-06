package org.aktic.convertToBST;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class Solution {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0 || nums == null) return null;

        int left = 0;
        int right = nums.length - 1;
        return divide(nums, left, right);
    }

    public static TreeNode divide(int[] nums, int left, int right) {
        if(left > right) return null;

        int mid = left + (right-left) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = divide(nums, left, mid - 1);
        node.right = divide(nums, mid + 1, right);

        return node;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        System.out.println(sortedArrayToBST(nums));
    }
}
