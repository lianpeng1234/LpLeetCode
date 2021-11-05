package com.lp.leetcode.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode98 {
    public boolean isValidBST(TreeNode root) {
        // 中序遍历二叉树，转换为有序数组
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);

        // 记录元素在 list 中的下标
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }

        return recursion(root, list, map);
    }

    // 中序遍历
    private static void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }

    private static boolean recursion(TreeNode node, List<Integer> list, HashMap<Integer, Integer> map) {
        if (node == null) {
            return true;
        }

        int index = map.get(node.val);

        // 查找第一个大于等于给定值的元素
        int xx = branchFindA(list, 0, index - 1, node.val);
        if (xx != -1) {
            return false;
        }
        // 查找最后一个小于等于给定值的元素
        xx = branchFindB(list, index + 1, list.size() - 1, node.val);
        if (xx != -1) {
            return false;
        }

        boolean xxx = recursion(node.left, list, map);
        if (!xxx) {
            return false;
        }
        return recursion(node.right, list, map);
    }

    // 查找第一个大于等于给定值的元素
    private static int branchFindA(List<Integer> a, int low, int height, int value) {
        while (low <= height) {
            int center = (height - low) / 2 + low;
            if (a.get(center) >= value) {
                if (center >= 1 && a.get(center - 1) >= value) {
                    height = center - 1;
                } else {
                    return center;
                }
            } else {
                low = center + 1;
            }
        }
        return -1;
    }

    // 查找最后一个小于等于给定值的元素
    private static int branchFindB(List<Integer> a, int low, int height, int value) {
        while (low <= height) {
            int center = (height - low) / 2 + low;
            if (a.get(center) <= value) {
                if (center < height && a.get(center + 1) <= value) {
                    low = center + 1;
                } else {
                    return center;
                }
            } else {
                height = center - 1;
            }
        }
        return -1;
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
