package com.lp.leetcode.other;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class LeetCode199 {

    public static void main(String[] args) {
        rightSideView(null);
    }

    // 广度优先搜索
    public static List<Integer> rightSideView(TreeNode root) {
        LinkedHashMap<Integer, List<Integer>> map = new LinkedHashMap<>();

        levelOrder(map, root, 0);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; ; i++) {
            List<Integer> xx = map.get(i);
            if (xx == null) {
                break;
            }
            result.add(xx.get(xx.size() - 1));
        }
        return result;
    }

    private static void levelOrder(LinkedHashMap<Integer, List<Integer>> map, TreeNode node, int treeDepth) {
        if (node == null) {
            return;
        }
        List<Integer> list = map.getOrDefault(treeDepth, new ArrayList<>());
        list.add(node.val);
        map.put(treeDepth, list);

        treeDepth++;
        levelOrder(map, node.left, treeDepth);
        levelOrder(map, node.right, treeDepth);

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
