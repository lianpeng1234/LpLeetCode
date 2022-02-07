package com.lp.leetcode.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCodeSwordOffer34 {

    private int targetNum;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        targetNum = target;

        List<List<Integer>> result = new ArrayList<>();

        LinkedList<Integer> tmpList = new LinkedList<>();

        recursion(root, 0, tmpList, result);

        return result;
    }

    private void recursion(TreeNode node, int sum, LinkedList<Integer> tmpList, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        sum = sum + node.val;
        tmpList.addLast(node.val);
        // 叶子节点
        if (node.left == null && node.right == null) {
            if (sum == targetNum) {
                result.add(new ArrayList<>(tmpList));
            }
        }

        recursion(node.left, sum, tmpList, result);
        recursion(node.right, sum, tmpList, result);
        tmpList.removeLast();
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
