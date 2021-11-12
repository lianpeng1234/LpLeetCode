package com.lp.leetcode.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode107 {
    private int maxDepth = 0;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        recursion(root, 0, map);

        List<List<Integer>> list = new ArrayList<>();
        for (int i = maxDepth - 1; i >= 0; i--) {
            list.add(map.get(i));
        }

        return list;
    }

    private void recursion(TreeNode node, int depth, Map<Integer, List<Integer>> map) {
        if (node == null) {
            maxDepth = Math.max(depth, maxDepth);
            return;
        }

        List<Integer> list = map.getOrDefault(depth, new ArrayList<>());
        list.add(node.val);
        map.put(depth, list);

        recursion(node.left, depth + 1, map);
        recursion(node.right, depth + 1, map);
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
