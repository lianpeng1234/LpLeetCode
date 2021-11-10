package com.lp.leetcode.other;

import java.util.*;

public class LeetCode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        recursion(root, 0, map);

        List<List<Integer>> returnList = new ArrayList<>();

        boolean left = true;
        for (int i = 0; i < map.size(); i++) {
            List<Integer> list = map.get(i);
            if (left) {
                left = false;
                returnList.add(list);
            } else {
                left = true;
                Collections.reverse(list);
                returnList.add(list);
            }
        }

        return returnList;
    }

    public void recursion(TreeNode node, int depth, Map<Integer, List<Integer>> map) {
        if (node == null) {
            return;
        }
        List<Integer> list = map.getOrDefault(depth, new ArrayList<>());
        list.add(node.val);
        map.put(depth, list);
        recursion(node.left, depth + 1, map);
        recursion(node.right, depth + 1, map);
    }

    public class TreeNode {
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
