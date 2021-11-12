package com.lp.leetcode.other;

public class LeetCode104 {
    private int max = 0;

    public int maxDepth(TreeNode root) {
        depth(root, 0);
        return max;
    }

    public void depth(TreeNode node, int depth) {
        if (node == null) {
            max = Math.max(max, depth);
            return;
        }
        depth(node.left, depth + 1);
        depth(node.right, depth + 1);
    }

    public class TreeNode {
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
