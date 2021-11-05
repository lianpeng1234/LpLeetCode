package com.lp.leetcode.other;

import java.util.*;

public class LeetCode236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> pPath = new HashMap<>();
        Map<Integer, TreeNode> qPath = new HashMap<>();

        // 找到目标节点，并保存从根节点触发经过的路径
        isFind(root, p, pPath, 0);
        isFind = false;

        // 找到目标节点，并保存从根节点触发经过的路径
        isFind(root, q, qPath, 0);
        isFind = false;

        // 将路径从map，转换为list
        List<TreeNode> pList = toList(pPath, p);

        // 将路径从map，转换为list
        List<TreeNode> qList = toList(qPath, q);

        // 找出路径中的最短的，从后往前遍历寻找父节点
        int min = Math.min(pList.size(), qList.size());
        for (int i = min - 1; i >= 0; i--) {
            if (pList.get(i).val == qList.get(i).val) {
                return pList.get(i);
            }
        }
        return null;
    }

    public List<TreeNode> toList(Map<Integer, TreeNode> path, TreeNode target) {
        List<TreeNode> list = new ArrayList<>();
        for (int i = 0; ; i++) {
            TreeNode node = path.get(i);
            if (node == null) {
                break;
            }
            if (node.val == target.val) {
                list.add(node);
                break;
            }
            list.add(node);
        }
        return list;
    }

    // 找到目标节点并保存，经过的路径
    public boolean isFind = false;
    public void isFind(TreeNode node, TreeNode target, Map<Integer, TreeNode> path, int depthTree) {
        if (node == null) {
            return;
        }
        if (isFind) {// 已找到
            return;
        }
        if (node.val != target.val) {
            path.put(depthTree, node);
        } else {
            path.put(depthTree, node);
            isFind = true;
        }

        isFind(node.left, target, path, depthTree + 1);
        isFind(node.right, target, path, depthTree + 1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
