package com.lp.leetcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 */
public class LeetCode102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedHashMap<Integer, List<Integer>> map = new LinkedHashMap<>();

        levelOrder(map, root, 0);

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; ; i++) {
            List<Integer> xx = map.get(i);
            if (xx == null) {
                return list;
            }
            list.add(xx);
        }
    }

    private void levelOrder(LinkedHashMap<Integer, List<Integer>> map, TreeNode node, int treeDepth) {
        if (node == null) {
            return;
        }
        List<Integer> list = map.getOrDefault(treeDepth, new ArrayList<>());
        list.add(node.val);
        map.put(treeDepth, list);

        treeDepth++;
        levelOrder(map, node.right, treeDepth);
        levelOrder(map, node.left, treeDepth);
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
