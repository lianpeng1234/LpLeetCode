package com.lp.leetcode.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<Integer> rootList = new ArrayList<>();
        HashMap<Integer, TreeNode> rootMap = new HashMap<>();
        traversal(root, rootList, rootMap);

//        System.out.println(rootList);

        List<Integer> subList = new ArrayList<>();
        HashMap<Integer, TreeNode> subMap = new HashMap<>();
        traversal(subRoot, subList, subMap);
//        System.out.println(subList);

        if (subList.size() == 1 && rootList.size() > 1) {
            TreeNode node = rootMap.get(subList.get(0));
            if (node.right != null || node.left != null) {
                return false;
            }
        }

        for (int i = 0; i < rootList.size(); i++) {
            int abc = i;
            for (int j = 0; j < subList.size(); j++) {
                if (abc >= rootList.size()) {
                    return false;
                }
                if (subList.get(j).intValue() == rootList.get(abc)) {
                    if (j == subList.size() - 1) {
                        return true;
                    }
                    abc++;
                } else if (subList.get(j).intValue() != rootList.get(abc)) {
                    break;
                }
            }
        }
        return false;
    }

    // 后续遍历
    public void traversal(TreeNode node, List<Integer> list, HashMap<Integer, TreeNode> map) {
        if (node == null) {
            list.add(Integer.MIN_VALUE);
            return;
        }
        traversal(node.left, list, map);
        traversal(node.right, list, map);
        list.add(node.val);
        map.put(node.val, node);
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
