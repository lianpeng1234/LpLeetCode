package com.lp.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        binaryTreePreorderTraversal(root, list);
        return list;
    }

    // 二叉树前序遍历
    private void binaryTreePreorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        binaryTreePreorderTraversal(node.left, list);
        binaryTreePreorderTraversal(node.right, list);
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



