package com.lp.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        binaryTreeInorderTraversal(root, list);
        return list;
    }

    // 二叉树中序遍历
    private void binaryTreeInorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        binaryTreeInorderTraversal(node.left, list);
        list.add(node.val);
        binaryTreeInorderTraversal(node.right, list);
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



