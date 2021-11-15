package com.lp.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class LeetCode114 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        recursion(root, list);

        TreeNode node = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            TreeNode tn = list.get(i);
            tn.right = node;
            tn.left = null;
            node = tn;
        }
    }

    private void recursion(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        recursion(node.left, list);
        recursion(node.right, list);
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
