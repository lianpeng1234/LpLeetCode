package com.lp.leetcode.other;

import java.util.List;

public class LeetCode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return recursion(p, q);
    }

    private boolean recursion(TreeNode a, TreeNode b) {
        if (a == null && b != null) {
            return false;
        }
        if (a != null && b == null) {
            return false;
        }
        if (a == null && b == null) {
            return true;
        }
        if (a.val != b.val) {
            return false;
        }
        boolean xx = recursion(a.left, b.left);
        if (xx) {
            return recursion(a.right, b.right);
        }
        return false;
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
