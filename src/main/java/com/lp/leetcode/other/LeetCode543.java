package com.lp.leetcode.other;

public class LeetCode543 {

    public int diameterOfBinaryTree(TreeNode root) {
        return recursion(root)-1;
    }

    private int maxPath = 0;
    public int recursion(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int l = recursion(node.left);
        int r = recursion(node.right);
        maxPath = Math.max(maxPath, l + r + 1);

        return Math.max(l, r) + 1;
    }


    public static class TreeNode {
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

}
