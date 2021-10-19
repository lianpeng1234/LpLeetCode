package com.lp.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        binaryTreePostorderTraversal(root, list);
        return list;
    }

    // 二叉树后序遍历
    private void binaryTreePostorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        binaryTreePostorderTraversal(node.left, list);
        binaryTreePostorderTraversal(node.right, list);
        list.add(node.val);
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



